package first_package;
import java.util.Scanner;
public class Addition {
	public static void main(String[] args) {
		Scanner input =new  Scanner(System.in);
		int num1,
		    num2,
		    sum;
		System.out.print("Enter first number:");
		num1 = input.nextInt();
		System.out.print("Enter second number:");
		num2 = input.nextInt();
		sum = num1+num2;
		System.out.println("the sum of these numbers is "+ sum);
		
	}
}
