package raceway;

import java.util.ArrayList;
import java.util.List;

import gui.OrderSelector;
import gui.PeopleSelector;
import gui.RaceFrame;

public class Order {
	
	//two types of orders
	public enum OrderType{
		hellOfAFeed, //$5 snack one with 1.5 slices
		hellishSnack; // $8 meal with 3 slices each
	}

	public boolean set = false; // this is used to make sure that number of people and order type are set
	
	OrderType order; //type of order
	int numberOfPeople; 
	
	double maxCost; //final cost
	double currentCost; //counter for the current cost
	List <Item> itemsInOrder; //All items in the final order

	//based on orderType
	double costPerPerson;  //individual customer cost
	private double slicesPerPerson; //amount of pizza slices a customer gets
	
	private String [] output;
	private double [] outputValues;
	
	/**
	 * create an order with no specified order type or number of players,
	 * will get this information from the player using a GUI and will display results on GUI
	 */
	public Order(){
		new OrderSelector(this);
		while(!set){
			System.out.println("");
			;

		}
	//	System.out.println("out of loop");
		set = false;
		new PeopleSelector(this);

		//new OrderSelector(this);
		
		while(!set){
			System.out.println("");
			;

		}
	//	System.out.println("out of loop");
			
		makeOrder();
		
		RaceFrame rFrame = new RaceFrame(this);

		
		//prints out the order
				for(Item p: itemsInOrder)
					System.out.println(p.getName());
				
				System.out.println();
				
				//print results
				for(int i = 0; i <output.length; i++)
					System.out.println(output[i]);

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
		
		//prints out the order
		for(Item p: itemsInOrder)
			System.out.println(p.getName());
		
		System.out.println();
		
		//print results
		for(int i = 0; i <output.length; i++)
			System.out.println(output[i]);
		
	}
	
	/**
	 * makes the given order
	 */
	private void makeOrder(){
		itemsInOrder = new ArrayList<Item>();
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

//		for(Item p: itemsInOrder)
//			System.out.println(p.getName());
		
		System.out.println("");
		
		assert((currentCost - costToDiscount)== maxCost); //this should always be the same

		output = new String [3];
		
		outputValues = new double [3];
		output[0] = ("the total order cost before discounts is $"+ (currentCost + 7.5)) ;
		outputValues[0] = (currentCost + 7.5) ;
		output[1] = ("The amount to discount is $7.50 delivery fee + $"+costToDiscount);
		outputValues[1] = +costToDiscount;
		output[2] = ("the final cost should be $"+ (currentCost - costToDiscount));
		outputValues[2] = currentCost - costToDiscount;
		
		
		
//		System.out.println("the total order cost before discounts is $"+ (currentCost + 7.5));
//		System.out.println("The amount to discount is $7.50 delivery fee + $"+costToDiscount);
//		System.out.println("the final cost should be $"+ (currentCost - costToDiscount));


	}
	
	public void checkSet(){
		if(order != null)// && numberOfPeople != 0)
			this.set = true;
	}
	
	public void setOrderType(OrderType type){
		this.order = type;
	}
	
	public void setNumberPeople(int i){
		numberOfPeople = i;
	}
	
	public void setNumberOfPeople(int people){
		this.numberOfPeople = people;
	}

	/**
	 * @return the itemsInOrder
	 */
	public List<Item> getItemsInOrder() {
		return itemsInOrder;
	}

	/**
	 * @return the output
	 */
	public String[] getOutput() {
		return output;
	}
	
	public double [] getOutputValues(){
		return outputValues;
	}
	
	public OrderType getOrderType(){
		return order;
	}
	
	public int getNumberPeople(){
		return numberOfPeople;
	}
	
	
}
