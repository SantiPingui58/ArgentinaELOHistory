package me.santipingui58.com;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GFG {

	public HashMap<String,Integer> sortByValue(HashMap<String,Integer> hm) {
		List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>> (hm.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			
			public int compare(Entry<String, Integer> o2, Entry<String, Integer> o1) {
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		HashMap<String,Integer> temp = new LinkedHashMap<String,Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		
		
		return temp;
	}
	
	public HashMap<String,Double> sortByDoubleValue(HashMap<String,Double> hm) {
		List<Map.Entry<String,Double>> list = new LinkedList<Map.Entry<String,Double>> (hm.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			
			public int compare(Entry<String, Double> o2, Entry<String, Double> o1) {
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		HashMap<String,Double> temp = new LinkedHashMap<String,Double>();
		for (Map.Entry<String, Double> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		
		
		return temp;
	}
}
