package snippet;

//Power set Of a String
public class AllCombinationOfString {

	public static void main(String[] args){
		powerSet("abc");
	}
	
	public static void powerSet(String input){
		for (int i = 1; i <(int) Math.pow(2,input.length()) ; i++) {

		    String element = "";
		    int arrayindex = 0;

		    for (int k = input.length() -1; k >= 0; k--) {

		        String index = ((i >> k) & 1) == 1 ? "1" : "0";

		        if(index == "1"){
		            element += input.charAt(arrayindex); 
		        }
		             arrayindex++;
		        }

		        System.out.println(element);
		    } 
	}
		
}

		
