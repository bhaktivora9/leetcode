package practice.recurssion;

import java.util.Scanner;

public class PronicNumber {
	static void checkForPronic(int number) {
		int n1 = 0, n2 = 0;
		for (int i = 0; i < number; i++) {
			if (i * (i + 1) == number) {
				n1 = i;
				n2 = i + 1;
				System.out.println("The number is a Pronic number");

			}
			
		}

		// n2 +n - number = 0;
		double sqrt = Math.sqrt(number);
		System.out.println(sqrt);
		int squareRoot = (int) sqrt;
		int product = squareRoot * (squareRoot + 1);
		if (product == number)
			System.out.println("The number is a Pronic number");
		else
			System.out.println("The number is not a Pronic number");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Number: ");
		int number = input.nextInt();
		checkForPronic(number);
	}
}