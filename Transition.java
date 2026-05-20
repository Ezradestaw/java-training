package first_package;

import java.util.Scanner;

public class Transition {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total  = 0;
		int gradeCounter = 0;
		System.out.println("Enter grade or -1 to quit:");
		int grade = input.nextInt();
		while (grade !=-1) {
			total += grade;
			gradeCounter +=1;
			System.out.println("Enter grade or -1 to quit:");
			grade = input.nextInt();
		}
		if (gradeCounter != 0) {
			double average =((double) total)/gradeCounter;
			System.out.println("The total of grades entered is: "+ total);
			System.out.println("Class average is :"+ average);
		}
		else {
			System.out.println("No Grades entered");
		}
	}

}
