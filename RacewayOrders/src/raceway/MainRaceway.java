package raceway;

import java.util.Scanner;

public class MainRaceway {

	public static void main(String[] args) {
		boolean valid = true;
		do{
		System.out.println("1) Hellish Snack ($5)");
		System.out.println("2) Hell of a Feed ($8)");
		Scanner scan = new Scanner(System.in);
		valid = true;
		try{
			int input = scan.nextInt();
		}
		catch(Exception e){
			System.out.println("only press 1 or 2");
			valid = false;
		}
		}while(!valid);
	}

}
