package snippet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class urlify {

	//Convert String to URL format
	public static void main(String[] args)throws IOException{
	ArrayList<Character> al= new ArrayList<Character>();
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter String");
	String s = "mr john smith    ";
	System.out.println("Enter true string length");
	int n = sc.nextInt();
	for(int i=0;i<n;i++){
		if(s.charAt(i)==' '){
			al.add('%');
			al.add('2');
			al.add('0');
		}
		else al.add(s.charAt(i));
	}
    StringBuilder builder = new StringBuilder(al.size());
    for(char c:al) builder.append(c);

	System.out.println(builder.toString());
	}
}
