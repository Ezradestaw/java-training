package first_package;
import  javax.swing.JOptionPane;
public class Dialog1 {
public static void main(String[] args) {
	String name = JOptionPane.showInputDialog("enter your name");
	String email = JOptionPane.showInputDialog("enter your email");
	String phoneNumber = JOptionPane.showInputDialog("enter your phone number");
	String department = JOptionPane.showInputDialog("enter your department");
	String university = JOptionPane.showInputDialog("enter your university");
	String message = String.format("Mr %s welcome to %s %n you are %s. %nyour contact is %s",name,university,department,email);
	
	JOptionPane.showMessageDialog(null, message);
	
}
}
