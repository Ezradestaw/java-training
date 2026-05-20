package first_package;
import java.util.Scanner;
public class Analysis {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int passes = 0;
		int failures = 0;
		int studentCounter = 1;
		int grade;
		
		while (studentCounter<=10) {
			System.out.print("Enter the next exam result: ");
			grade  = input.nextInt();
			if (grade ==1) 
				passes +=1;
			else
				failures +=1;
			studentCounter +=1;
		}
		System.out.println("the number of passed students is: "+ passes);
		System.out.println("the number of failures students is: "+ failures);
		if (passes>=8) {
			System.out.println("Bonus to Instructor");
		}
		
	}

}
