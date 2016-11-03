package gui;

import raceway.Order;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;



public class OrderSelector extends JFrame {

	Order order;
	public OrderSelector(Order order){
		super("Which Type Of Order");
		this.order = order;
		
		if(this.order == null)
			System.out.println("order is null");
		
		assert(order != null);
		
		setLayout(new FlowLayout());
		
		
		ButtonGroup group = new ButtonGroup();
		JRadioButton snack = new JRadioButton("Hellish Snack");
		JRadioButton feed = new JRadioButton("Hell of A Feed");

		add(snack);
		add(feed);
		group.add(snack);
		group.add(feed);

		snack.addItemListener( (ItemListener) new SelectedNumber(2));
		feed.addItemListener( (ItemListener) new SelectedNumber(3));

		ButtonGroup group2 = new ButtonGroup();

		
		JRadioButton b = new JRadioButton("8");
		JRadioButton b1 = new JRadioButton("7");
		JRadioButton b2 = new JRadioButton("4");
		JRadioButton b3 = new JRadioButton("5");
		JRadioButton b4 = new JRadioButton("6");
		
		setLayout(new FlowLayout());
	//	add(group2);
		group2.add(b);
		group2.add(b1);
		group2.add(b2);
		group2.add(b3);
		group2.add(b4);
		
		add(b);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		



		setSize(500, 100);
		setVisible(true);
	}
	private class SelectedNumber implements ItemListener{	
	
		private int selection;

		public SelectedNumber (int i){
			selection = i;
		}

		@Override
		public void itemStateChanged(ItemEvent arg0) {			
			//Give the game the desired number of players for it
			if(selection == 2)
				order.setOrderType(Order.OrderType.hellishSnack);
			else
				order.setOrderType(Order.OrderType.hellOfAFeed);
			
			//remove window after selection is made
			setVisible(false);
			dispose();
			
			
		}

	}

}
