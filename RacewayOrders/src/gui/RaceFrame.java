package gui;


import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import raceway.Order;

@SuppressWarnings("serial")
public class RaceFrame extends JFrame implements java.awt.event.KeyListener{
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
		addKeyListener((KeyListener) this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
