package first_package;
import java.util.Scanner;
public class SecondAccount {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account customer1 = new Account("Mr. Ezra Destaw Mekonnen",0);
		customer1.deposit(-777);
		System.out.println(customer1.getBalance());
	
	}

}
