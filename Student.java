package first_package;

public class Student {
	private String name;
	private double average;
	
public Student(String name, double average) {
	this.name = name;
	if (average>=0.0 && average <=100.0) 
		this.average = average;	
	
}
public void setName(String name) {
	this.name = name;
}
public String getName() {
	return name;
}
public void setAverage(double average) {
	if (average>=0.0 && average <=100.0) 
		this.average = average;	
}
public double getAverage() {
	
	return average;
}
public String getLetterGrade() {
	if (average>=90) 
		return "A+";
	else if (average >= 85) 
		return "A";
		
	else if (average >=80)
		return "A-";
	else if (average>=75)
		return "B+";
	else if (average>=68)
		return "B";
	else if (average>=65)
		return "B-";
	else if (average>=60)
		return "C+";
	else if (average>=50)
		return "C";
	else if (average>=45)
		return "C-";
	else if (average>=40)
		return "D";
	else
		return "F";
	
	
}
}
