package snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
//Deserialise a graph and find path between 2 nodes
//Create a graph by inputing it the following way.
//1,2,#2,3#3,1 
//here '#' sereprates each node, the first num represents the node label and foolowing node represents its neighbours.
//In the above example 1 is the label and 2 is it's neighboring node.
//similarly after first '#' 2 is label and 3 is its neighbor.

public class FindPathInGraph {
	
	public static void main(String[] args){
		Graph a=deserializeGraph("1,2,5#2,1,4#4,2,#5,1#2,3");
		ArrayList<Graph> al=findPath(a,3);
		for(int i=al.size()-1;i>=0;i--) System.out.print(al.get(i).label+" ");
		
	}
	
	
	
	private static ArrayList<Graph> findPath(Graph a, int target){
		Queue<Graph> queue = new LinkedList<Graph>();
		HashSet<Graph> hs = new HashSet<Graph>();
		HashMap<Graph,Graph> hm = new HashMap<>();
		Graph temp = a;
		queue.add(temp);
		hs.add(temp);
		while(!queue.isEmpty()){
			temp = queue.poll();
			if(temp.label==target) break;
			else{
				for(Graph node: temp.adjacent){
					if(!hs.contains(node)){
						queue.add(node);
						hs.add(node);
						hm.put(node, temp);
					}
				}
			}
		}
		ArrayList<Graph> ans = new ArrayList<>();
		if(temp.label!=target) return null;
		else{
			for(Graph graph = temp;graph!=null;graph=hm.get(graph))
				ans.add(graph);
		}
		
		return ans;
	}
	
private static Graph deserializeGraph(String str){
		
		HashMap<Integer,Graph> hm = new HashMap<>();
		String[] arr= str.split("#");
		for(String s:arr){
			String[] v= s.split(",");
			Graph newnode;
			if(hm.containsKey(Integer.parseInt(v[0]))) newnode = hm.get(Integer.parseInt(v[0]));
			else newnode = new Graph(Integer.parseInt(v[0]));
			hm.put(newnode.label,newnode);
			for(int i=1;i<v.length;i++){
				if(hm.containsKey(Integer.parseInt(v[i]))){
					newnode.adjacent.add(hm.get(Integer.parseInt(v[0])));
				}
				else {
					Graph nextnode= new Graph(Integer.parseInt(v[i]));
					hm.put(nextnode.label, nextnode);
					newnode.adjacent.add(nextnode);
				}
			}
		}
		
		return hm.get(Integer.parseInt(Character.toString(str.charAt(0))));
		
	}


}

//Uncomment this class before running the program
//class Graph {
//	int label;
//	ArrayList<Graph> adjacent = new ArrayList<Graph>();
//	Graph(int x){ this.label= x;}
//}

