package com.xyq.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test13 extends JFrame implements ActionListener{
	
	 JButton button = new JButton();
	 public Test13(){
		  button.addActionListener(this); //��Ӽ�����
		  this.add(button);
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //���ð��رռ����ɹرմ���
		  this.setSize(400,300);
		  this.setVisible(true);  //���ӻ�
	 }
	 public void actionPerformed(ActionEvent e) {
		 this.setVisible(false);  //���岻�ɼ�
		 new Frame2();  //�����µĴ��壬�Դﵽ�л������Ч��
	 }
	 public static void main(String[] args){
		 new Test13();
	 }
	 private class Frame2 extends JFrame{
		  public Frame2(){
			   JTextField text = new JTextField();
			   this.add(text);
			   this.setSize(600, 480);
			   this.setVisible(true);
		   }
	 }
}
