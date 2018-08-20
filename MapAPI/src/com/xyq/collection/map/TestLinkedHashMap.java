package com.xyq.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestLinkedHashMap {
	public static void main(String[] args) {
		//linkedHashMap有序 按照输入顺序输出
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		
		map.put(1006, "z3");
		map.put(1002, "l4");
		map.put(1005, "w5");
		map.put(1001, "z6");
		map.put(1004, "z3");
		
		System.out.println(map.size());
		System.out.println(map);
		
		//按照key值升序或降序排列
		Map<Integer, String> map2 = new TreeMap<Integer, String>();
		map2.put(1006, "z3");
		map2.put(1002, "l4");
		map2.put(1005, "w5");
		map2.put(1001, "z6");
		map2.put(1004, "z3");
		
		System.out.println(map2);
		
		
		
		
	}
}
