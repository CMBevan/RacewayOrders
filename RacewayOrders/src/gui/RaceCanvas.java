package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import raceway.Item;
import raceway.Order;
import raceway.Order.OrderType;

public class RaceCanvas extends JPanel {

	Order order;
	List <Item>items;
	String [] output;
	double [] outputValues;

	public final int startX = 100;
	public final int startY = 245;

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
		outputValues = order.getOutputValues();

		assert(this.items != null);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	@Override
	public Dimension getPreferredSize(){
		return new Dimension (800,990);
	}

	@Override
	public void paint(Graphics g){
		
		g.drawString("- please double check and make sure that the output makes sense, in the end it's not my fault if you give out 5 doubles to a two person order!!!!", 5, 50);
		g.drawString("- Also please only use as a guide and replace items as required: e.g. Vege Pizzas & G.F. Pizzas are specifically requested,", 5, 80);
		g.drawString("   or replacing some wedges with G.Bread if heaps of wedges and not many G.Breads", 5, 95);
		
		g.setColor(Color.BLUE);
		g.drawString("Calculating for " + order.getNumberPeople() + " " + order.getOrderType()+"s", 5,140 );
		g.drawString("At the individual person price at: "+ ((order.getOrderType() == OrderType.hellishSnack)?"$5.00":"$8.00"), 5,155);
		//g.drawString("In the end it's not my fault if you give out 5 doubles to a two person order!!!!", 5, 60);
		
		g.setColor(Color.BLACK);
		//outside boxes
		g.drawRect(startX -10, startY -20, 250,items.size() * 20+5); //outside box
		g.drawRect(startX -10, startY -20, 150,items.size() * 20 + 5); //outside box
		
		//top boxes
		g.drawRect(startX - 10, startY -50, 250, 30);
		g.drawRect(startX - 10, startY -50, 150, 30);

		int i = 0;
		for(;i<items.size();i++){
			g.drawString(items.get(i).getName(), startX , startY + (i*20)); // print the name
			g.drawString(" $"+ String.format("%.2f",items.get(i).getCost()), startX + 150 , startY + (i*20)); // print the cost
		}
			
		//total before discount
		g.drawString("Order Total", startX, startY + (i*20));
		g.drawString(" $"+String.format("%.2f",outputValues[0]), startX+150, startY + (i*20));
		i++;
		
		//delivery discount
		g.drawString("Delivery Discount", startX, startY + (i*20));
		g.setColor(Color.RED);
		g.drawString("-$"+String.format("%.2f",7.5), startX+150, startY + (i*20));
		i++;
		
		//discount
		g.setColor(Color.BLACK);
		g.drawString("Order Discount", startX, startY + (i*20));
		g.setColor(Color.RED);
		g.drawString("-$"+String.format("%.2f",outputValues[1]), startX+150, startY + (i*20));
		i++;
		
		//final total
		g.setFont(new Font("Arial", Font.BOLD, 14));
		g.setColor(Color.BLACK);
		g.drawString("Final Total", startX, startY + (i*20));
		g.drawString(" $"+String.format("%.2f",outputValues[2]), startX+150, startY + (i*20));
		i++;
		
		//top titles
		g.drawString("Item", startX + 20 , startY -30); // print the name
		g.drawString(" Price", startX + 150, startY - 30);
		
		//bottom boxes for discounts
		g.drawRect(startX -10, startY -20, 250,i * 20+5); //outside box
		g.drawRect(startX -10, startY -20, 150,i * 20 + 5); //outside box
		g.drawRect(startX -10, startY -20, 250,(i-1) * 20+5); //outside box
		g.drawRect(startX -10, startY -20, 150,(i-1) * 20 + 5); //outside box

		g.setFont(new Font("Arial", Font.ITALIC, 11));
		g.drawString("- Source Code at: https://github.com/CMBevan/RacewayOrders", 5, 20);
		//print the order out
	}
}
