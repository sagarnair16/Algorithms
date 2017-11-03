package snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



//Deserialise a graph and BFS
//Create a graph by inputing it the following way.
//1,2,#2,3#3,1 
//here '#' sereprates each node, the first num represents the node label and foolowing node represents its neighbours.
//In the above example 1 is the label and 2 is it's neighboring node.
// similarly after first '#' 2 is label and 3 is its neighbor.

public class GraphDeserializeAndBFS {
	
	public static void main(String[] args){
			check();
		}
	
	public static void check(){
		Graph a=deserializeGraph("1,2,4#2,1,3#3,2,4#4,1,3");
		bfs(a);
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

	private static void bfs(Graph a) {
		Queue<Graph> queue = new LinkedList<Graph>();
		queue.add(a);
		HashSet<Graph> hs = new HashSet<Graph>();
		while(!queue.isEmpty()){
			Graph temp=queue.poll();
			if(!hs.contains(temp)) hs.add(temp);
			System.out.print(temp.label);
			for(Graph node:temp.adjacent){
				if(!hs.contains(node)){
					queue.add(node);
					hs.add(node);
				}
			}
			
		}
	}

		
}

//class Graph {
//int label;
//ArrayList<Graph> adjacent = new ArrayList<Graph>();
//Graph(int x){ this.label= x;}
//}
