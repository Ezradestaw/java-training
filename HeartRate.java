package first_package;

public class HeartRate {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	public HeartRate(String firstName, String lastname, Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastname;
		this.dateOfBirth =  dateOfBirth;
		
	}
	//
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	//
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLasttName() {
		return lastName;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	//
	public int calculteAge(Date dateOfBirth) {
		return 2026-dateOfBirth.getYear();
	}
	public int maxHeartRate(int age) {
		return 220 -  calculteAge(Date dateOfBirth);
	}


}
