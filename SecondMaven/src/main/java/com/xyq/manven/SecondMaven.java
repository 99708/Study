package com.xyq.manven;

import com.xyq.maven.HelloMaven;

public class SecondMaven {
	
	public String say(String name) {
		HelloMaven firstMaven = new HelloMaven();
		return firstMaven.say(name);
	}

}
