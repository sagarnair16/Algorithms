package snippet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public class ParenthesisMatching {
	
	public static void main(String[] args)throws IOException{
		String[] str = {"{([])}","[][]","((){}","[[]]]","[[[[[]"};
		String[] ans=answer(str);
		for(String s:ans) System.out.println(s);
	}
	public static String[] answer(String[] str){
		ArrayList<String> al = new ArrayList<String>();
		for(String s:str){
			al.add(solution(s));
		}
		
		String[] ans = al.toArray(new String[al.size()]);
		return ans;
		
	}
	
	public static String solution(String str){
		
		char arr[] = str.toCharArray();
		Stack<Character> st = new Stack<Character>();
		
		for(char c:arr){
			if(c=='{' || c=='[' || c=='('){
				st.push(c);
			}
			if(c=='}' || c==']' || c==')'){
				if(st.isEmpty()) return "NO";
				else{
					char x=st.pop();
					if(x=='{') if(c!='}') return "NO";
					if(x=='(') if(c!=')') return "NO";
					if(x=='[') if(c!=']') return "NO";
				}
				
			}
		}
		if(st.isEmpty()) return "Yes";
		else return "NO";
		
	}
	
	
		
		
					
}
