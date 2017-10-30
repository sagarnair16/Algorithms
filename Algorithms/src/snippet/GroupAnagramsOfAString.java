package snippet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsOfAString {
	
	public static void main(String[] args){
		
		String[] arr={"car","cheating","dale","deal","lead","listen","silent","teaching"};
		Arrays.sort(arr);
		for(String str:arr)System.out.print(str+" ");
		String[] soln=groupAnagrams(arr);
		for(String s:soln)
			System.out.println(s);
		
		
	}
	
	
	
	public static String[] groupAnagrams(String[] strs) {
		
        if (strs == null || strs.length == 0){
        	System.out.println("Invalid Input");
        	return new String[0];
        }
        
        ArrayList<String> als = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
            map.get(keyStr).add(s);
        }
        ArrayList<List<String>> al = new ArrayList<List<String>>(map.values());
    	//Collections.sort(al);
        for(List<String> li :al){
        	if(li.size()<2) continue;
            StringBuilder sb = new StringBuilder();
        	for(String str:li){
        		sb.append(str+" ");
        	}
        	als.add(sb.toString());
        }
		return als.toArray(new String[als.size()]);
    }

}
