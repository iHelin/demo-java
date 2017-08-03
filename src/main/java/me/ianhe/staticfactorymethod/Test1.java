package me.ianhe.staticfactorymethod;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test1 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		System.out.println("1.通过Map.keySet遍历key和value：");
		for (String key : map.keySet()) {
			System.out.println("  key: " + key + " value: " + map.get(key));
		}

		System.out.println("2.通过Map.entrySet使用iterator遍历key和value：");
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println("  key: " + entry.getKey() + " value: " + entry.getValue());
		}
		System.out.println("3.通过Map.entrySet遍历key和value");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("  key: " + entry.getKey() + " value: " + entry.getValue());
		}

		// 第四种
		System.out.println("4.通过Map.values()遍历所有的value，但不能遍历key");
		for (String v : map.values()) {
			System.out.println("  value: " + v);
		}
	}

	public static <K, V> HashMap<K, V> newInstance() {
		return new HashMap<K, V>();
	}
}
