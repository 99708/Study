package com.xyq.test03;

import java.util.Random;
import java.util.concurrent.Callable;

public class Demo1 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		return new Random().nextInt(10);
	}


}
