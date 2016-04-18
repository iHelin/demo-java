package com.ihelin.test;

import java.util.HashMap;
import java.util.Map;

public class Person {
	public static void main(String[] args) {
		Map<String,Object> proMap = new HashMap<String,Object>(); 
		proMap.put("a", 1);
		proMap.put("b", 2);
		proMap.put("c", 3);
		proMap.put("c", 4);
		System.out.println(proMap.get("c"));
	}
	
	public String prt(){
		return "fewf";
				
	}
}
