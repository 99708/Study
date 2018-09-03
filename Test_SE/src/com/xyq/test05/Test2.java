package com.xyq.test05;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入用户名");
		String name = sc.nextLine();
		if("".equals(name)) {
			System.out.println("用户名不能为空");
		}else if(name.length() <= 6) {
			System.out.println("用户名长度必须大于6");
		}else {
			for(int i=0; i<name.length(); i++) {
				if(Character.isDigit(name.charAt(i))) {
					System.out.println("用户名中不能含有数字");
					return;
				}
			}
		}
		
	}

}
