package com.xyq.string;

public class TestString {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder(3);
		StringBuilder sb2 = new StringBuilder("aaa");//19 用去3个
		
		sb2.append("");
		//假设添加17个 17 + 3 = 20 > 19 -> 扩容   19 << 1  + 2  即 19 * 2 + 2；利用Arrays.copyOf(String str, int len);
		//如果要添加的长度> 19 * 2 + 2 长度 ，新数组的长度变为要添加的长度，value=新数组；
		
		StringBuffer sbf = new StringBuffer();
		StringBuffer sbf2 = new StringBuffer(3);
		StringBuffer sbf3 = new StringBuffer("aaa");
		
		String s = new String();
		String s1 = new String("aaa");
	}
}
