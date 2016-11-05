package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import raceway.Item;
import raceway.Order;

public class RaceCanvas extends JPanel {

	Order order;
	List <Item>items;
	String [] output;

	public final int startX = 100;
	public final int startY = 70;

	/**
	 * new canvas with the order information, must always be called after Order.makeOrder()
	 * @param order
	 */
	public RaceCanvas (Order order){
		super();
		this.order = order;
		assert(this.order != null);
		items = order.getItemsInOrder();
		output = order.getOutput();

		assert(this.items != null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	@Override
	public Dimension getPreferredSize(){
		return new Dimension (800,900);
	}

	@Override
	public void paint(Graphics g){
		g.drawRect(startX -10, startY -20, 300,items.size() * 20 +20); //outside box
		g.drawRect(startX -10, startY -20, 150,items.size() * 20 +20); //outside box



		for(int i = 0;i<items.size();i++){
			g.drawString(items.get(i).getName(), startX , startY + (i*20)); // print the name
			g.drawString("$"+Double.toString(items.get(i).getCost()), startX + 150 , startY + (i*20)); // print the cost
		}
		
		for(int i = 0; i< output.length;i++)
			g.drawString(output[i], startX -10, startY +( items.size() * 20 + 40) + (i * 20));

		//print the order out
	}
}
