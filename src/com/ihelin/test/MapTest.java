package com.ihelin.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(4, 2);
		
		Iterator<?> entries = map.entrySet().iterator();  
		  
		while (entries.hasNext()) {  
		  
		    Map.Entry entry = (Map.Entry) entries.next();  
		  
		    Integer key = (Integer)entry.getKey();  
		  
		    Integer value = (Integer)entry.getValue();  
		  
		    System.out.println("Key = " + key + ", Value = " + value);  
		  
		}
	}

}
