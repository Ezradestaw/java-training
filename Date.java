package first_package;

public class Date {
	private int month;
	private int day;
	private int year;
	public Date(int month,int day,int year) {
		if (month>=1 && month <=12 ) {
			this.month = month;
		}
		if (day>=1 && day <=12 ) {
			this.day = day;
		}
		if (year>=1 && year <=2026 ) {
			this.year = year;
		}
		
		
	}
	public void setMonth(int month) {
		if (month>=1 && month <=12 ) {
			this.month = month;
		}
	}
	public int getMonth() {
		return month;
	}
	
	//
	public void setDay(int day) {
		if (day>=1 && day <=12 ) {
			this.day = day;
		}
	}
	public int getday() {
		return day;
	}
	//
	public void setYear(int day) {
		if (year>=1 && year <=2026 ) {
			this.year = year;
		}
	}
	public int getYear() {
		return year;
	}
	public void displayDate() {
		System.out.println("Today is :"+month+"/"+day+"/"+year);
	}
	
	

}
