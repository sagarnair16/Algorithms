package snippet;

public class StringDecompression {
	
	public static void main(String[] args){
		
		compress("a2b3c123");
		
	}
	
	public static void compress(String str){
		int i=0;
		StringBuilder sb = new StringBuilder();
		
		while(i<str.length()){
			if(i==0 || i%2==0){
				int j=Character.getNumericValue(str.charAt(i+1));
				while(j>0){ 
					sb.append(str.charAt(i));
					j--;
					}
			}
			i++;
		}
		
		System.out.println(sb.toString());
		
	}

}

