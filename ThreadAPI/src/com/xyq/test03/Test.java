package com.xyq.test03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Demo1 demo1 = new Demo1();
		FutureTask<Integer> ft = new FutureTask<Integer>(demo1);
		Thread t = new Thread(ft);
		t.start();
		System.out.println(ft.get());
	}
}
