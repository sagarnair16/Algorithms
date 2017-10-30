package snippet;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
//All unique characters in a String
public class uniquechar {
	public static void main(String[] args)throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String str=sc.nextLine();
		if(unique(str))
			System.out.print("No duplicates");
		else System.out.print("There are duplicates");
	}
	
	public static boolean unique(String str){
		HashSet<Character> hs = new HashSet<Character>();
		char arr[]= str.toCharArray();
		
		for(char c:arr){
			if(hs.contains(c)) return false;
			else hs.add(c);
		}
		return true;

	}
}