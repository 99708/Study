package com.xyq.manven;

import org.junit.Test;

import junit.framework.Assert;

public class TestSecondMaven {
	
	@Test
	public void TestSecondMaven() {
		SecondMaven secondMaven = new SecondMaven();
		String result = secondMaven.say("z3");
		Assert.assertEquals("hello z3", result);
	}

}
