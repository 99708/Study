package com.xyq.test;

import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Test12 extends JFrame {
	public static void main(String[] args) {
		new Test12();
	}

	private JPanel jpsnl;
	private JButton but1;
	private JButton but2;
	private JButton but3;
	Image bgimg=GameUtil.getImage("images/2.jpg");
	public Test12()  throws HeadlessException {
		
		jpsnl =new JPanel(null);
		ImageIcon background = new ImageIcon(bgimg);
		//设置为一个标签，标签大小设置和窗口一样
		JLabel label = new JLabel(background);
		label.setBounds(0, 0, jpsnl.getWidth(), jpsnl.getHeight());
		//把内容窗口格式化转化为Jpanel,不能用方法setOpaque()来使内容窗格透明	
		jpsnl.setOpaque(false);//改成false为透光的
		jpsnl.add(label, new Integer(Integer.MIN_VALUE));
		
		but1=new JButton("开始游戏");
		but2=new JButton("结束游戏");
		but3=new JButton("游戏说明");
		but1.setOpaque(false);
		but2.setOpaque(false);
		but3.setOpaque(false);
		but1.setOpaque(false);
		but1. setBorder(null);
        setFocusable(false);
//        setBackground(null);
        but2.setOpaque(false);
		but2. setBorder(null);
		but3.setOpaque(false);
		but3. setBorder(null);

		
		but1.setBounds(850, 100, 100, 50);
		but2.setBounds(850, 250, 100, 50);
		but3.setBounds(850, 400, 100, 50);
		but();
	}
	/**
	 * @throws HeadlessException
	 */
	public void but() throws HeadlessException {
		this.add(jpsnl);
		jpsnl.add(but1);
		but1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		jpsnl.add(but2);
		but2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		jpsnl.add(but3);
		but3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
	
		setTitle("尚学堂学员");
		setVisible(true);
		setSize(1024,665);
		setLocation(100,50);
	
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		
	}
	

	public void paint(Graphics g){	
		g.drawImage(bgimg, 0, 0, null);
		Image lg=GameUtil.getImage("images/start.png");
		ImageIcon login = new ImageIcon(lg);
		but1.setIcon(login);
		but2.setIcon(login);
		but3.setIcon(login);
	}

}