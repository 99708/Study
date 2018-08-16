package com.xyq.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestCollection {
	public static void main(String[] args) {
		Collection co = new ArrayList();
		
		//增加元素
		co.add("hello");
		co.add("world");
		co.add("!");
		
		System.out.println(co.size());
		
		Collection co2 = new ArrayList();
		co2.add("你好");
		co2.add("世界");
		co2.add("!");
		System.out.println(co2.size());
		
		co.addAll(co2);
		System.out.println(co.size());
		
		//删除元素
//		co.clear();
		
//		co.remove("hello");
//		System.out.println(co.size());
		
		//判断
//		System.out.println(co.isEmpty());
//		System.out.println(co2.isEmpty());
		System.out.println(co.contains("hello"));
		
		//遍历
		//增强的for循环
		for(Object o : co) {
			System.out.println(o);
		}
		//迭代器
		
		System.out.println("=================");
		Iterator iterator = co.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
}
