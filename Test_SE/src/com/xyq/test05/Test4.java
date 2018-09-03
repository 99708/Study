package com.xyq.test05;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入灯的颜色");
		String color = sc.next();
		Color color1 = null;
		try {
			color1 = Enum.valueOf(Color.class, color);
		} catch (Exception e) {
			try {
				throw new Exception("你的输入有误");
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
				return;
			}
		}
		
		Car car = new Car(color1);
		car.run();
	}

}

class Car{
	private Color color;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Car(Color color) {
		this.color = color;
	}
	
	public Car() {
	}
	
	public void run() {
		switch(color) {
		case 红:
			System.out.println("汽车停车");
			break;
		case 绿:
			System.out.println("汽车行驶");
			break;
		case 黄:
			System.out.println("汽车慢行");
		}
	}
}

enum Color{
	红,绿,黄;
}
