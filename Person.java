import java.util.Scanner;

public class Person {
	
	// Attributes.
	String title;
	String firstName;
	String lastName;
	String phoneNumber;
	String email;
	String address;
	
	// Methods.
	
	// Create 'Person' object for contractor, architect and customer.
	public Person(String title, Scanner input){
		this.title = title;
		
		System.out.printf("Please enter the %s first name: ", title);
		this.firstName = input.next();
		
		System.out.printf("Please enter the %s last name: ", title);
		this.lastName = input.next();
		
		System.out.printf("Please enter the %s phone number: ", title);
		this.phoneNumber = input.next();
		
		System.out.printf("Please enter the %s email address: ", title);
		this.email = input.next();
		
		System.out.printf("Please enter the %s physical address. Use ';' to indicate separate lines:\n", title);
		this.address = input.next();
	}
	
	// Call each attribute.
	public String getTitle(){
		return title;
	}
	
	public String getName(){
		String output = String.format("%s %s", firstName, lastName);
		return output;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getAddress(){
		return address;
	}
	
	// Call all attributes.
	public String getPerson(){
		String output = "Designation:\t" + title;
		output += "\nName:\t" + getName();
		output += "\nNumber:\t" + phoneNumber;
		output += "\nEmail:\t" + email;
		output += "\nAddress:\t" + address;
		
		return output;
	}

}