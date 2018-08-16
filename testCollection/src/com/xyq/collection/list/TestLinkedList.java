package com.xyq.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

public class TestLinkedList {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		/*
		 * LinkedList常用方法：
		 * 增加：addFirst(E e)     addLast(E e)
		 *     offerFirst(E e)   offerLast(E e) 
		 * 删除：pollFirst()      pollLast()  ---健壮性 好 
		 *     removeFirst()    removeLast() 
		 * 修改：
		 * 查看：element()
		 *     getFirst()   getLast()
		 *     peekFirst()  peekLast()
		 * 判断：
		 */

		
		list.add("java");
		list.add("css");
		list.add("js");
		list.add("jq");
		
		System.out.println(list.size());
//		list.clear();
//		System.out.println(list.element());
//		System.out.println(list.peekFirst());
//		System.out.println(list.peekLast());
//		System.out.println(list.getFirst());
		
		
//		System.out.println(list.pollFirst());
//		System.out.println(list.removeFirst());
//		System.out.println(list.size());
		System.out.println(list);
		list.addFirst("hello");
		System.out.println(list);
		list.offerFirst("world");
		System.out.println(list);
		
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
	
}
