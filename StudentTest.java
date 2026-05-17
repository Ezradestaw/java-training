package first_package;

public class StudentTest {
	public static void main(String[] args) {
		Student zeaman = new Student("Zeamanuel Jenbere",84.8);
		Student getch = new Student("Getachew Eyayu",79.9);
		System.out.println(zeaman.getName());
		System.out.println(getch.getName());
		System.out.println(zeaman.getAverage());
		getch.setAverage(0-1);
		System.out.println(getch.getAverage());
		System.out.println(getch.getLetterGrade());
		System.out.println(zeaman.getLetterGrade());
		
	}

}
