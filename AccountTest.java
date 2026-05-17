package first_package;
import java.util.Scanner;
public class AccountTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account customer1 = new Account("Ezra Destaw",50.00);
		Account customer2 = new Account("Ezra Destaw",-73.55);
		System.out.printf("%s balance: $%.2f%n%n",customer1.getName(),customer1.getBalance());
		System.out.printf("%s balance: $%.2f%n%n",customer2.getName(),customer2.getBalance());
     
		System.out.print("Enter deposit amount for customer1:");
		double depositAmount = input.nextDouble();
		System.out.printf("%nadding %.2f to customer1 balance %n%n", depositAmount);
		customer1.deposit(depositAmount);
		System.out.printf("%n%s balance: $%.2f%n%n",customer1.getName(),customer1.getBalance());
		System.out.printf("%n%s balance: $%.2f%n%n",customer2.getName(),customer2.getBalance());
		System.out.print("Enter withdraw amount for customer1:");
		double withdrawamount = input.nextDouble();
		customer1.withdraw(withdrawamount);
		System.out.println("the amount of balance for customer1 is:"+customer1.getBalance());
		
	}

}
