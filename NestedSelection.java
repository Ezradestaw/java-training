package first_package;

public class NestedSelection {
	public static void main(String[] args) {
		java.util.Scanner input  = new java.util.Scanner(System.in);
		float grade = input.nextFloat();
		if (grade>=90)
			System.out.println("A");
		else {
			if (grade>80)
				System.out.println("B");
			else {
				if (grade>70)
					System.out.println("C");
				else {
					if (grade>50)
						System.out.println("D");
					else 
						System.out.println("F");
				}
			}
		}
	}

}
