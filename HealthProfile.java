package first_package;

public class HealthProfile {
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private float height;
	private float weight;
	public HealthProfile(String firstName,String lastName,String gender,Date dateOfBirth,float height,float weight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.weight = weight;
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
	public String getLastName() {
		return lastName;
	}
	//
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	//
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	//
	public void setHeight(float height) {
		this.height = height;
	}
	public float getHeight() {
		return height;
	}
	//
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getWeight() {
		return weight;
	}
	public int calculateGe() {
		return 2026-Date.getYear();
	}
	

}
