package snippet;

public class Permutation {

	public static void main(String[] args){
		
		int i=0;
		String str="ab";
		permute(str,i);
		
	}
	
	public static void permute(String str,int i){
		
		if(i==str.length()-1) System.out.println(str);
		
		int j=i;
		while(j<str.length()){
			str= swap(str,i,j);
			permute(str,i+1);
			j++;
		}
		
	}

	private static String swap(String s, int i, int j) {
		char[] str = s.toCharArray();
		char temp= str[i];
		str[i]=str[j];
		str[j]=temp;
		
		return String.valueOf(str);
	}
		
		
}
