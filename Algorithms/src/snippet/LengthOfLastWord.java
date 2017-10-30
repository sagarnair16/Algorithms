package snippet;

public class LengthOfLastWord {
	
	public static void main(String[] args){
		System.out.println(solution("Hello everyone my name is Sagar"));
	}
	
	public static int solution(String str){
		
		if(str.trim().length()==0) return 0;
		String[] s= str.split(" ");
		
		
		return s[s.length-1].length();
	}

}
