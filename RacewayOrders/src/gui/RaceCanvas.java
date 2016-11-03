package gui;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RaceCanvas extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	@Override
	public Dimension getPreferredSize(){
		return new Dimension (1920,1080);
	}

}
