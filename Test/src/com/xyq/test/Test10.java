/**
 * ʹ��javaʵ�ֳ����ƶ���С��
 */

package com.xyq.test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Test10 extends JFrame{
    //�����ƶ�����
    int x = 0;
    int y = 0;
    int m = 100;
    int n = 100;
    //������
    public static void main(String[] args) {
        new Test10();
    }
    //ʹ�ù������������岢����
    public Test10(){
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(3);
        this.setLocation(400, 100);
        this.setResizable(false);
        this.setTitle("���Կ��");
        move();
    }
    //��д��ͼ����
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, 25 + y, 50, 50);
    }
    //����С���ƶ��켣
    public void move(){
        while(true){
            x += m;
            y += n;
            if(x >= 450){
                m = -m; 
            }
            if(x < 0){
                m = 1;
            }
            if(y >= 425){
                n = -n;
            }
            if(y < 0){
                n = 1;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}