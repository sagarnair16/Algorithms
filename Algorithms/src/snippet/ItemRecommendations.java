package snippet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Create a recommendation system based on item dependency
// In the following example if someone buys item 3 they should get item3 and item4 as recommendations.
public class ItemRecommendations {
	
	static HashMap<String,Set<String>> hm = new HashMap<String, Set<String>>();
	
	public static  void main(String[] args){
		ArrayList<Aoa> al= new ArrayList<Aoa>();
		al.add(new Aoa("item1","item2"));
		al.add(new Aoa("item3","item4"));
		al.add(new Aoa("item4","item5"));
		createMap(al);
		addDepen(al);
		answer(hm);
	}

	private static void answer(HashMap<String, Set<String>> hm2) {
		for(String s: hm2.keySet()){
			System.out.println(s+" "+hm2.get(s));
		}
	}

	private static void addDepen(ArrayList<Aoa> al) {
		Set<String> temp = new HashSet<String>();
		for(String s: hm.keySet()){
			Set<String> val= hm.get(s);
			for(String str: val){
				if(hm.containsKey(str)){
					Set<String> value2=hm.get(str);
					temp.addAll(value2);
				}
			}
			val.addAll(temp);
			hm.put(s, val);
		}
		
	}

	private static void createMap(ArrayList<Aoa> al) {
		for(int i=0;i<al.size();i++){
			String s1=al.get(i).s1;
			String s2=al.get(i).s2;
		if(!hm.containsKey(s1))
			hm.put(s1,new HashSet<>());
		if(!hm.containsKey(s2))
			hm.put(s2,new HashSet<>());
	}
		
		
		
		for(String s: hm.keySet())
			for(int i=0;i<al.size();i++){
				if((al.get(i).s1).equals(s)){
					Set<String> res = hm.get(s);
					res.add(al.get(i).s2);
					hm.put(s, res);
				}
		}
		
			
	}

	private static void display(ArrayList<Aoa> al) {
		for(int i=0;i<al.size();i++){
				System.out.println(al.get(i).s1+" "+al.get(i).s2);
		}
		
	}
	
}

class Aoa{
	String s1;
	String s2;
	
	public Aoa(String first, String second){
		this.s1=first;
		this.s2=second;
	}

}


	
