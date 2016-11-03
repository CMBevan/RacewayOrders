package raceway;

import java.util.ArrayList;
import java.util.List;

import gui.OrderSelector;
import gui.RaceFrame;

public class Order {
	
	//two types of orders
	public enum OrderType{
		hellOfAFeed, //$5 snack one with 1.5 slices
		hellishSnack; // $8 meal with 3 slices each
	}

	boolean set = false; // this is used to make sure that number of people and order type are set
	
	OrderType order; //type of order
	int numberOfPeople; 
	
	double maxCost; //final cost
	double currentCost; //counter for the current cost
	List <Item> itemsInOrder; //All items in the final order

	//based on orderType
	double costPerPerson;  //individual customer cost
	private double slicesPerPerson; //amount of pizza slices a customer gets
	
	public Order(){
		new OrderSelector(this);
		RaceFrame rFrame = new RaceFrame();
		while(!set){
			
		}
	}

	/**
	 * used to put together an order using the type of desired order and the number of people within the order
	 * @param order
	 * @param people - number of people per order
	 */
	public Order(OrderType order, int people){
		this.order = order;
		this.numberOfPeople = people;
		makeOrder();
	}
	
	/**
	 * makes the given order
	 */
	private void makeOrder(){
		itemsInOrder = new ArrayList<>();
		List <Pizza> pizzasList = Pizza.addToList(); //get a list full of pizzas
		
		if(order == OrderType.hellishSnack){
			costPerPerson = 5;
			slicesPerPerson = 1.5;
		}
		//order type is hellOfAFeed
		else{
			costPerPerson = 8;
			slicesPerPerson = 3;
		}
		maxCost = costPerPerson * numberOfPeople;

		double slicesNeeded = numberOfPeople * slicesPerPerson;

		double pizzasNeeded = slicesNeeded / 8;

		long totalNeededPizzas = Math.round(pizzasNeeded);

		//add the needed number of pizzas to the order
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

		//add sides until we are over the maxCost
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

		System.out.println("");
		System.out.println("the order is:");

		for(Item p: itemsInOrder)
			System.out.println(p.getName());
		
		System.out.println("");
		
		assert((currentCost - costToDiscount)== maxCost); //this should always be the same

		System.out.println("the total order cost before discounts is $"+ (currentCost + 7.5));
		System.out.println("The amount to discount is $7.50 delivery fee + $"+costToDiscount);
		System.out.println("the final cost should be $"+ (currentCost - costToDiscount));


	}
	
	public void setOrderType(OrderType type){
		this.order = type;
	}
	
	public void setNumberOfPeople(int people){
		this.numberOfPeople = people;
	}
}
