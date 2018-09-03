package com.xyq.test;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test11{

	public static void main(String[] args) {
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	       public void run() {
	           createAndShowGUI();
	       }
	    });
	}
	
	private static void createAndShowGUI() {
	    // Create and set up the window.
	    JFrame frame = new JFrame("FlowLayoutDemo");
	    frame.setSize(700,480);
	    frame.setLocationRelativeTo(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    // Set up the content pane.
	    addComponentsToPane(frame.getContentPane());
	    // Display the window.
	    frame.pack();
	    frame.setVisible(true);
	}
	
	public static void addComponentsToPane(Container pane) {
	    
//		pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
	    JPanel yPanel = new JPanel();
	    yPanel.setLayout(new BoxLayout(yPanel, BoxLayout.Y_AXIS));
	    yPanel.setPreferredSize(new Dimension(700,480));
	    yPanel.add(Box.createVerticalStrut(100));
	    addButtons(yPanel);
	    
	    pane.add(yPanel, BorderLayout.PAGE_START);
	}
	 
	private static void addAButton(String text, Container container) {
	    JButton button = new JButton(text);
	    button.setAlignmentX(Component.CENTER_ALIGNMENT);
	    container.add(button);
	}
	 
	private static void addButtons(Container container) {
	    addAButton("Button 1", container);
	    container.add(Box.createVerticalStrut(20));
	    addAButton("Button 2", container);
	    container.add(Box.createVerticalStrut(20));
	    addAButton("Button 3", container);
	    container.add(Box.createVerticalStrut(20));
	    addAButton("Long-Named Button 4", container);
	    container.add(Box.createVerticalStrut(20));
	    addAButton("5", container);
	}
}