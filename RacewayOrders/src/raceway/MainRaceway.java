package raceway;

import java.util.Scanner;

public class MainRaceway {

	public static void main(String[] args) {
		boolean valid = true;
		int input = -1;
		int people = -1;
		do{
			System.out.println("While I am an amazing programmer please double check and make sure that the output makes sense!");
			System.out.println("In the end it's not my fault if you give out 5 doubles to a two person order!!!!");
			System.out.println("");
			System.out.println("");


			System.out.println("1) Hellish Snack ($5): or ");
			System.out.println("2) Hell of a Feed ($8): ");
			Scanner scan = new Scanner(System.in);
			valid = true;
			try{
				input = scan.nextInt();

				if(input != 1 && input != 2 && input != 3)//invalid choice
					throw new Exception();

				System.out.println("How many people for the order?");

				people = scan.nextInt();
				if(people <= 0 || input >50) //invalid choice
					throw new Exception();
			}
			/*
			 * catches any errors, and repeats the loop
			 */
			catch(Exception e){
				System.out.println("only press 1 or 2, or choose a +ve number of people and no more than 50");
				valid = false;
			}
			scan.close();

		}while(!valid); //we dont have a valid choice



		if(input == 1)
			new Order(Order.OrderType.hellishSnack, people);

		else if (input == 2)
			new Order(Order.OrderType.hellOfAFeed, people);
		else
			new Order();

	}

}
