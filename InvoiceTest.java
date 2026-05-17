package first_package;

public class InvoiceTest {
	public static void main(String args[]) {
		Invoice laptop = new Invoice("952592480","Samsung a25 phone",100,-322);
		System.out.println(laptop.getInvoiceAmount());
	}

}
