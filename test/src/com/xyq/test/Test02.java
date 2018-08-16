package com.xyq.test;

public class Test02 {
	public static void main(String[ ] args) {
		StringBuffer a = new StringBuffer("A");
		StringBuffer b = new StringBuffer("B");
		mb_operate(a, b);
	} 
	static void mb_operate(StringBuffer x, StringBuffer y) {
		x.append(y);
		y = x;
	} 

}
