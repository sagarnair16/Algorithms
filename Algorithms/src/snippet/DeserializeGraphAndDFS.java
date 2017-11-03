package snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



//Deserialise a graph and DFS
//Create a graph by inputing it the following way.
//1,2,#2,3#3,1 
//here '#' sereprates each node, the first num represents the node label and foolowing node represents its neighbours.
//In the above example 1 is the label and 2 is it's neighboring node.
// similarly after first '#' 2 is label and 3 is its neighbor.

public class DeserializeGraphAndDFS {
	
	public static void main(String[] args){
			check();
		}
	
	public static void check(){
		Graph a=deserializeGraph("1,2,4#2,1,3#3,2,4#4,1,3");
		dfs(a);
	}


	private static void dfs(Graph a) {
		Stack<Graph> st = new Stack<>();
		HashSet<Graph> hs = new HashSet<>();
		st.push(a);
		hs.add(a);
		System.out.print(a.label);
		while(!st.isEmpty()){
			Graph temp= st.peek();
			if(temp.adjacent.isEmpty() || allNodesVisited(temp,hs)) st.pop();
			else{
				ArrayList<Graph> al = temp.adjacent;
				for(Graph node:al){
					if(!hs.contains(node)){
						System.out.print(node.label);
						st.push(node);
						hs.add(node);
						break;
					}
				}
			}
		}
		
	
	}
	
	public static boolean allNodesVisited(Graph a,HashSet<Graph> hs){		
		for(Graph temp:a.adjacent){
			if(!hs.contains(temp)) return false;
		}
		
		
		return true;
		
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

class Graph {
	int label;
	ArrayList<Graph> adjacent = new ArrayList<Graph>();
	Graph(int x){ this.label= x;}
}

