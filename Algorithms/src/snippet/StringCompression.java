package snippet;

public class StringCompression {
	
	
	public static void main(String[] args){
		String str="aabbccddd";
		String ans=solution(str);
		if(ans.length()<str.length()) System.out.println(ans);
		else System.out.println(str);
	}
	
	public static String solution(String str){
		int i=0,j=0,count=0;
		StringBuilder sb = new StringBuilder();
		
		while(j<str.length()){
			if(i==j){
				count++;
				j++;
			}
			else if(i!=j && str.charAt(i)==str.charAt(j)){
				count++;
				j++;
			}
			else if(i!=j && str.charAt(i)!=str.charAt(j)){
				sb.append(str.charAt(i));
				sb.append(count);
				count=0;
				i=j;
			}
			
		}
		sb.append(str.charAt(i));
		sb.append(count);
		return sb.toString();
		
	}

}
