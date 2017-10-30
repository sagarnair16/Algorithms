//Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
//
//For example, with A = "abcd" and B = "cdabcdab".
//
//Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").


package snippet;

public class RepeatedStringMatch {

	
	public static void main(String[] args){
		System.out.println(repeatedStringMatch("abcd","cdabcdab"));
	}
	
	 public static int repeatedStringMatch(String A, String B) {
	        int b= B.length(),count=1;
	        StringBuilder sb = new StringBuilder();
	        sb.append(A);
	        while(sb.length()<=2*b){
	            if(sb.length()>=b){
	                if(sb.toString().contains(B)){
	                    return count;
	                }
	                else{
	                    sb.append(A);
	                    count++;
	                }
	            }
	            else{
                    sb.append(A);
                    count++;
                }
	        }
	              
	              return -1;
	    }
}
