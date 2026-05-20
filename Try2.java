package first_package;
import java.util.Scanner;
public class Try2 {
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		double total = 0;
		int gradeCounter = 1;
		while (gradeCounter<=10) {
			System.out.println("enter grade: ");
			int grade = input.nextInt();
			total += grade;
			gradeCounter +=1;
		}
		double average = total/gradeCounter;
		System.out.println(average);
		
		
	}

}
