package com.xyq.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class TestList {
	public static void main(String[] args) {
		//增加元素
		List list = new ArrayList();//ArrayList默认为"{}",容量为0的数组, ArrayList 扩容至后变为原来的1.5倍,
		//如果扩容之后还不能满足就将容量设为需要的容量
		
		Vector vecotr = new Vector();//默认创建一个长度为10的Object数组, 扩容的时候是如果容量增量大于0
		//就扩为原来容量加容量增量，否则变为原来的2倍;如果扩容之后还不能满足就将容量设为需要的容量
		
		list.add("hello");
		list.add("world");
		list.add("!");
		list.add("hello");
		System.out.println(list);
		
		//修改元素
//		list.set(1, "世界");
//		System.out.println(list);
	
		//删除元素
		list.remove(1);
		System.out.println(list);
		
		//遍历元素
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(Object o : list) {
			System.out.println(o);
		}
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}
}
