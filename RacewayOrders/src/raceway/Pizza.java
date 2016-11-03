package raceway;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Pizza implements Item{

	public static List <Pizza> items;

	private String name;
	private double cost;

	/**
	 * create a pizza class with a name and a cost to it
	 * @param name
	 * @param cost
	 */
	public Pizza(String name, double cost){
		this.name = name;
		this.cost = cost;
	}

	public double getCost(){
		return cost;
	}
	
	public String getName(){
		return name;
	}
	
	public static List <Pizza> addToList(){
		items = new ArrayList<>();
		items.add(new Pizza("Lust",16));
		items.add(new Pizza("Greed",16));
		items.add(new Pizza("Gluttony",16));
		items.add(new Pizza("Pandy",18.5));
		items.add(new Pizza("Envy",16));
		items.add(new Pizza("Grimm",18.5));
		items.add(new Pizza("Mordor",18.5));
		items.add(new Pizza("Pride",16));
		items.add(new Pizza("Lust",16));
		items.add(new Pizza("Greed",16));
		items.add(new Pizza("Gluttony",16));
		items.add(new Pizza("Pandy",18.5));
		items.add(new Pizza("Envy",16));
		items.add(new Pizza("Grimm",18.5));
		items.add(new Pizza("Mordor",18.5));
		items.add(new Pizza("Pride",16));
		items.add(new Pizza("Lust",16));
		items.add(new Pizza("Greed",16));
		items.add(new Pizza("Gluttony",16));
		items.add(new Pizza("Pandy",18.5));
		items.add(new Pizza("Envy",16));
		items.add(new Pizza("Grimm",18.5));
		items.add(new Pizza("Mordor",18.5));
		items.add(new Pizza("Pride",16));
		return items;
	}

}
