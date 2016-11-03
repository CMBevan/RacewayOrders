package raceway;

import java.util.Scanner;

public class MainRaceway {

	public static void main(String[] args) {
		boolean valid = true;
		int input = -1;
		int people = -1;
		do{
			System.out.println("1) Hellish Snack ($5)");
			System.out.println("2) Hell of a Feed ($8)");
			Scanner scan = new Scanner(System.in);
			valid = true;
			try{
				input = scan.nextInt();
				if(input != 1 && input != 2)
					throw new Exception();
				System.out.println("How many people for the order?");
				people = scan.nextInt();
				if(people <= 0 || input >50)
					throw new Exception();
			}
			catch(Exception e){
				System.out.println("only press 1 or 2");
				valid = false;
			}
		}while(!valid);

		if(input == 1)
			new Order(Order.OrderType.hellishSnack, people);
		else
			new Order(Order.OrderType.hellOfAFeed, people);

	}

}
