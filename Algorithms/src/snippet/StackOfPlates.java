package snippet;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfPlates {
	
	static int threshold =4;
	static ArrayList<Stack<Integer>> al = new ArrayList<Stack<Integer>>();
	public static void main(String[] args){
		int[] arr= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		for(int i:arr) push(i);
		
		printall();
	}
	
	public static void push(int x){
		if(al.isEmpty()){
			Stack<Integer> st = new Stack<Integer>();
			st.push(x);
			al.add(st);
		}
		else{
		Stack<Integer> st = al.get(al.size()-1);
		if(st.size()<threshold){
			st.push(x);
		}
		else{
			Stack<Integer> ns = new Stack<Integer>();
			ns.push(x);
			al.add(ns);
		}
		}
	}
	
	public int pop(){
		Stack<Integer> st =  al.get(al.size()-1);
		if(st.isEmpty()){
			al.remove(al.size()-1);
			st=  al.get(al.size()-1);
			return st.pop().intValue();
		}
		else{
			return st.pop().intValue();
		}
	}
	
	public static void printall(){
		for(Stack<Integer> st:al){
			System.out.println("Stack "+al.indexOf(st));
			while(!st.isEmpty()){
				System.out.println(st.pop());
			}
		}
	}
}
