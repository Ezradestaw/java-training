package first_package;
import java.util.Scanner;

public class Comparison {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number1,number2;
		System.out.print("Enter the first number: ");
		number1 = input.nextInt();
		System.out.print("Enter the second number: ");
		number2 = input.nextInt();
		if (number1==number2) {
			System.out.printf("%d == %d%n", number1,number2);
		}
		if (number1!=number2) {
			System.out.printf("%d != %d%n", number1,number2);
		}
		if (number1>number2) {
			System.out.printf("%d > %d%n", number1,number2);
		}
		if (number1>=number2) {
			System.out.printf("%d >= %d%n", number1,number2);
		}
		if (number1<number2) {
			System.out.printf("%d < %d%n", number1,number2);
		}
		if (number1<=number2) {
			System.out.printf("%d <= %d%n", number1,number2);
		}
		if (false);
		System.out.println("ezra the great");
		double lorentzFacto = 3+4
				+4;
		System.out.println(lorentzFacto);
	}

}
