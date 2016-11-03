package raceway;

public class FryerSide implements Item {

	private double cost;
	private String name;
	
	public FryerSide(String name, double cost){
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
	public static FryerSide getSide(double remainder){
		return (remainder > 4.5)? new FryerSide("Wedges, plain", 5): new FryerSide("Garlic Bread", 4.5);
	}
}
