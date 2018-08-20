package com.xyq.enumer;

public class Demo2 {
	public static void main(String[] args) {
		
		Season s = Season.春;
		switch(s) {
		case 春: System.out.println("春天"); break;
		case 夏: System.out.println("夏天"); break;
		case 秋: System.out.println("秋天"); break;
		case 冬: System.out.println("冬天"); break;
		}
	}
}
