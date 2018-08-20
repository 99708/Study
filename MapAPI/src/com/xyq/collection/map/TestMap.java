package com.xyq.collection.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap {
	public static void main(String[] args) {
		/**
		 * 增加   put(K key, V value) 
		 * 删除 remove(Object key)
		 * 修改
		 * 查找 entrySet() get(Object key) keySet() size() values() 
		 * 判断 containsKey(Object key) containsValue(Object value)
		 */
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println(map.put(1001, "z3"));
		map.put(1002, "l4");
		map.put(1005, "w5");
		System.out.println(map.put(1001, "z6"));
		map.put(1004, "z3");
		
		System.out.println(map);
		System.out.println(map.size());
		
		map.remove(1004);
		System.out.println(map);
		System.out.println(map.size());
		
		System.out.println(map.containsKey(1004));
		System.out.println(map.containsValue("l4"));
		
		System.out.println("------");
		//遍历
		//方式1
		Set<Integer> keys = map.keySet();
		for(Integer key:keys) {
			System.out.println(key);
		}
		
		//方式2
		Collection<String> values = map.values();
		for(String value:values) {
			System.out.println(value);
		}
		
		System.out.println("==================================");
		
		//方式3 Entry 是HashMap的内部接口
		Set<Entry<Integer, String>> entrySets = map.entrySet();
		for(Entry entry:entrySets) {
			System.out.println(entry.getValue());
			System.out.println(entry.getKey());
		}
		
		
	}
}
