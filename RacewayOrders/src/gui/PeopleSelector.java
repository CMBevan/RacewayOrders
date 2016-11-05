package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import raceway.Order;

public class PeopleSelector extends JFrame {

	Order order;
	public PeopleSelector(Order order){
		super("How many people for the order?");

		this.order = order;
		
		assert(this.order != null);
		
		String s [] = new String [43];
		for(int i = 0;i<43;i++){
			s[i] = Integer.toString(i+3);
		}
		//JComboBox cb = new JComboBox(new String []{"one","two"});
		JComboBox cb = new JComboBox(s);
		add(cb);
		cb.setEditable(false);
		cb.addActionListener(new SelectedNumber());
		setSize(400, 100);
		setVisible(true);
	}
	private class SelectedNumber implements ActionListener{	


		public SelectedNumber (){

		}


		public void actionPerformed(ActionEvent e) {
			JComboBox box = (JComboBox) e.getSource();

			String s = (String) box.getSelectedItem(); //get selected value
			
			order.setNumberPeople(Integer.valueOf(s)); //set number of people
			order.set = true; //allow Order to continue
			
			setVisible(false);
			dispose();
		}



	}
}
