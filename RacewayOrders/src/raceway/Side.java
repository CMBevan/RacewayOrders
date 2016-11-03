package raceway;

public class Side implements Item {

	private double cost;
	private String name;
	
	public Side(String name, double cost){
		this.cost = cost;
		this.name = name;
	}
	
	public double getCost(){
		return cost;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * used to get a side depending on the amount passed in
	 * @param remainder - amount of money left
	 * @return - new side given
	 */
	public static Side getSide(double remainder){
		return (remainder > 4.5)? new Side("Wedges, plain", 5): new Side("Garlic Bread", 4.5);
	}
}
