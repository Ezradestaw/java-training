package first_package;

public class Invoice {
	private String partNumber;
	private String partDescription;
	private int quantity;
	private double price;
	public Invoice(String partNumber, String partDescription, int quantity,double price) {
		this.partNumber=partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.price = price;
	}
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public void setPartDesctiprion(String partDescription) {
		this.partDescription = partDescription;
	}
	public String getPartDescription() {
		return partDescription;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public double getInvoiceAmount() {
		if (quantity <= 0) {
			return 0;
		}
		else if(price < 0) {
			return 0.0;
		}else {
			return quantity * price;
		}
		
	}
	
}
