package raceway;

import java.util.ArrayList;
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
	List <Item> itemsInOrder; //All items in the final order

	//based on orderType
	double costPerPerson; 
	private double slicesPerPerson; 

	public Order(OrderType order, int people){
		itemsInOrder = new ArrayList<>();
		List <Pizza> pizzasList = Pizza.addToList(); //get a list full of pizzas

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

		long totalNeededPizzas = Math.round(pizzasNeeded);
		System.out.println("pizzas needed (rounded): "+ totalNeededPizzas);

		//add the needed number of pizza
		for(int i = 0; i < totalNeededPizzas; i++){
			Pizza p = pizzasList.remove(0);
			
			//make sure our new pizza is not null
			if(p == null){
				System.err.println("An error has occured or too much people in an order");
				System.exit(-1);
			}
			else{
				this.currentCost += p.getCost();
				itemsInOrder.add(p);
			}
		}
		
		System.out.println("current cost is: $"+ currentCost);
		System.out.println("price difference is: $"+ (maxCost - currentCost));

		while(currentCost < maxCost){
			Side s = Side.getSide(maxCost - currentCost);
			currentCost += s.getCost();
			itemsInOrder.add(s);
		}
		
		
		
	/*-------------------------------------------------------------------------------- */
		double costToDiscount;
		if(currentCost > maxCost+6){
			System.err.println("something has gone really wrong!");
			System.exit(-2);
		}

		costToDiscount = currentCost - maxCost;

		System.out.println("the order is:");

		for(Item p: itemsInOrder)
			System.out.println(p.getName());
		
		System.out.println("");
		assert((currentCost - costToDiscount)== maxCost);

		System.out.println("the total order cost before discounts is"+ currentCost);
		System.out.println("The amount to discount is $7.50 delivery fee + $"+costToDiscount);
		System.out.println("the final cost should be $"+ (currentCost - costToDiscount));


	}
}
