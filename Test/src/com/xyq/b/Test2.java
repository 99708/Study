package com.xyq.b;

import com.xyq.a.Test1;
import com.xyq.a.Test3;

public class Test2 {
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.add(1);
		System.out.println(t1.getList());
		Test3 t3 = new Test3();
		t3.printList();
	}
}
