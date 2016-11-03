package raceway;

import java.util.List;

public class Order {
	public enum OrderType{
		hellOfAFeed,
		hellishSnack;
	}

	OrderType order; //type of order
	int numberOfPeople; 
	final double maxCost; //final cost
	double currentCost; //counter for the current cost
	List <Item> items; //All items in the final order
	
	//based on orderType
	double costPerPerson; 
	private double slicesPerPerson; 

	public Order(OrderType order, int people){
		this.order = order;
		this.numberOfPeople = people;

		if(order == OrderType.hellishSnack){
			costPerPerson = 5;
			slicesPerPerson = 1.5;
		}
		else{
			costPerPerson = 8;
			slicesPerPerson = 3;
		}
		maxCost = costPerPerson * people;
		System.out.println("Total Cost is: $"+ maxCost);

		double slicesNeeded = people * slicesPerPerson;
		System.out.println("Slices needed: "+ slicesNeeded);
		
		double pizzasNeeded = slicesNeeded / 8;
		System.out.println("pizzas needed: "+ pizzasNeeded);
		
		long pizzas = Math.round(pizzasNeeded);
		System.out.println("pizzas needed (rounded): "+ pizzas);

	}
}
