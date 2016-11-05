package gui;


import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import raceway.Order;

@SuppressWarnings("serial")
public class RaceFrame extends JFrame {
	RaceCanvas canvas;
	
	public RaceFrame(Order order){
		super();
		canvas = new RaceCanvas(order);
		setLayout(new BorderLayout());      // use border layour
		add(canvas, BorderLayout.CENTER);   // add canvas
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();                             // pack components tightly together
		setResizable(false);                // prevent us from being resizeable
		setVisible(true);                   // make sure we are visible!
	}

}
