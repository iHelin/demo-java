package me.ianhe.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 2);
		map.put("4", 2);
		Iterator<?> entries = map.entrySet().iterator();
		while (entries.hasNext()) {
			Entry<String, Object> entry = (Entry<String, Object>) entries.next();
			String key = (String) entry.getKey();
			Integer value = (Integer) entry.getValue();
			System.out.println("Key = " + key + ", Value = " + value);

		}
	}

}
