package raceway;

import java.util.List;

public class Order {
	public enum OrderType{
		hellOfAFeed,
		hellishSnack;
	}
	
	OrderType order; //type of order
	int numberOfPeople; 
	double maxCost; //final cost
	double currentCost; //counter for the current cost
	double costPerPerson; 
	List <Pizza> items; 
	
	public Order(OrderType order, int people){
		this.order = order;
		this.numberOfPeople = people;
		
		if(order == OrderType.hellishSnack)
			costPerPerson = 5;
		else
			costPerPerson = 8;
		
		
	}
}
