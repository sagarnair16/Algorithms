package snippet;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

	public static void main(String[] args){
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		
		a.left=b;
		a.right=c;
		c.left=d;
		c.right=e;
		
		
		deserializeBFS("3 2 3 * 3 1 * * * * ");
		//printLevelOrder(a);
		
		
	}
	
	public static int level(Node node){
		
		if(node==null) return 0;
		
		int left=1+level(node.left);
		int right=1+level(node.right);
		return Math.max(left, right);
		
	}
	
	 static void printLevelOrder(Node root)
	    {
	        int h = level(root);
	        int i;
	        for (i=1; i<=h; i++)
	            printGivenLevel(root, i);
	    }
	 static void printGivenLevel (Node root ,int level)
	    {
	        if (root == null){
	        	System.out.print("Null ");
	        	return;
	        }
	        if (level == 1)
	            System.out.print(root.val + " ");
	        else if (level > 1)
	        {
	            printGivenLevel(root.left, level-1);
	            printGivenLevel(root.right, level-1);
	        }
	    }
	
	



public static void serializeBFS(Node root){
	 Queue<Node> queue = new LinkedList<Node>();
	 StringBuilder sb= new StringBuilder();
	 queue.add(root);
	 
	 while(!queue.isEmpty()){
		 Node node=queue.poll();
		 if(node==null) {
			 sb.append("*");
			 sb.append(" ");
		 }
		 else{
			 sb.append(node.val);
			 sb.append(" ");
			 if(node.left==null) queue.add(null);
			 else queue.add(node.left);
			 if(node.right==null) queue.add(null);
			 else queue.add(node.right);
		 }
	 }
	System.out.println(sb.toString());
	deserializeBFS(sb.toString());
}

public static void deserializeBFS(String serial){
	Queue<Node> queue = new LinkedList<Node>();
	String[] arr= serial.split(" ");
	Node n= new Node(Integer.parseInt(arr[0]));
	queue.add(n);
	int i=1;
	while(!queue.isEmpty()){
		Node node=queue.poll();
		if(!arr[i].equals("*")){
		node.left=new Node(Integer.parseInt(arr[i]));
		queue.add(node.left);
		i++;
		}else{
			node.left=null;
			i++;
		}
		
		if(!arr[i].equals("*")){
			node.right=new Node(Integer.parseInt(arr[i]));
			queue.add(node.right);
			i++;
			}else{
				node.right=null;
				i++;
			}
		
	}
	
	printLevelOrder(n);
}

}
class Node{
	int val;
	Node left;
	Node right;
	
	Node(int x){
		this.val=x;
	}
}
