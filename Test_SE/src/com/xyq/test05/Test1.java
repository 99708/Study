package com.xyq.test05;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入分数");
		int score = sc.nextInt();
		try {
			if(score >= 0 && score <= 100) {
				System.out.println(score);
			}else {
				throw new Exception("分数必须在0—100之间");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
