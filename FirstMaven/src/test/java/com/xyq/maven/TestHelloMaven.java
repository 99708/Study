package com.xyq.maven;

import org.junit.Test;

import junit.framework.Assert;

public class TestHelloMaven {
	
	@Test
	public void testHelloMaven() {
		HelloMaven helloMaven = new HelloMaven();
		String result = helloMaven.say("z3");
		Assert.assertEquals("hello z3",result);
	}
}
