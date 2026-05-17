package first_package;

public class EmployeeTest {
	public static void main(String[] args) {
		Employee zeaman = new Employee("Zeamanuel","Jembere",45000);
		Employee gech = new Employee("Getachew","Eyayu",49000);
//		zeaman.setSalary(zeaman.getSalary()*1.1);
//		gech.setSalary(gech.getSalary()*1.1);
		System.out.println("the yearly salary for zeaman is: "+ zeaman.getSalary()* 12 + "Birr");
		System.out.println("the yearly salary for gech is: "+ gech.getSalary()* 12 + "Birr");
		System.out.println();
		System.out.println();
		zeaman.setSalary(zeaman.getSalary()*1.1);
		gech.setSalary(gech.getSalary()*1.1);
		System.out.println("the yearly salary for zeaman is: "+ zeaman.getSalary()* 12 + "Birr");
		System.out.println("the yearly salary for gech is: "+ gech.getSalary()* 12 + "Birr");
	}

}
