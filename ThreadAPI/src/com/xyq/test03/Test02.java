package com.xyq.test03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test02 implements Callable<String> {

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getPriority()+"";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Test02 t = new Test02();
		FutureTask<String> st = new FutureTask<String>(t);
		Thread tt = new Thread(st);
		tt.setPriority(2);
		tt.start();
		System.out.println(st.get());
	}
}
