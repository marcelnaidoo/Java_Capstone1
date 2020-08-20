import java.time.LocalDate;
import java.util.Scanner;

public class ProjectDetails {
	
	// Attributes.
	String projectNumber;
	String projectName;
	String buildingType;
	String buildingAddress;
	String erfNumber;
	float totalFee;
	float totalPaid;
	LocalDate deadline;
	// Person class created separately.
	Person architect;
	Person contractor;
	Person customer;
	boolean completed;
	
		
	// Methods.
		
	// Create 'Project' object.
	// Came across error when inputting int/float input, created a separate scanner variable to remedy this.
	public ProjectDetails(Scanner input, Scanner numberInput) {
		this.customer = new Person("Customers", input);
		
		System.out.print("\nPlease enter the project number: ");
		this.projectNumber = input.next();
		
		System.out.print("Please enter the type of building: ");
		this.buildingType = input.next();
		
		System.out.print("Please enter the project name, or 'no' to autogenerate: ");
		String projectNameChoice = input.next();
		if (projectNameChoice.equalsIgnoreCase("no")) {
			this.projectName = buildingType + " " + customer.lastName;
		}
		else {
			this.projectName = projectNameChoice;
		}
		
		
		System.out.println("Please enter the building physical address. Use ';' to indicate separate lines: ");
		this.buildingAddress = input.next();
		
		System.out.print("Please enter the buildings ERF number: ");
		this.erfNumber = input.next();
		
		System.out.print("Please enter the job fee: ");
		this.totalFee = numberInput.nextFloat();
		System.out.print("Please enter how much the customer has paid to date: ");
		this.totalPaid = numberInput.nextFloat();
		
		System.out.print("Please enter the deadline following these instructions.\n");
		System.out.print("Please enter the year the project is due: ");
		int year = numberInput.nextInt();
		System.out.print("Please enter the month (using '1' for Jan to '12' for Dec) the project is due: ");
		int month = numberInput.nextInt();
		System.out.print("Please enter the day of the month the project is due: ");
		int day = numberInput.nextInt();
		this.deadline = LocalDate.of(year, month, day);
		System.out.println("");
		
		this.architect = new Person("Architects", input);
		System.out.println("");
		
		this.contractor = new Person("Contractors", input);
		
		this.completed = false;
	}
	
	// Call each attribute.
	public String getProjectNumber(){
		return projectNumber;
	}
		
	public String getprojectName(){
		return projectName;
	}
		
	public String getbuildingType(){
		return buildingType;
	}
		
	public String getbuildingAddress(){
		return buildingAddress;
	}
		
	public String geterfNumber(){
		return erfNumber;
	}
	
	public float getTotalFee(){
		return totalFee;
	}
	
	public float getTotalPaid(){
		return totalPaid;
	}
	
	public LocalDate getDeadline(){
		return deadline;
	}
	
	public Person getArchitect(){
		return architect;
	}
	
	public Person getContractor(){
		return contractor;
	}
	
	public Person getCustomer(){
		return customer;
	}
		
	// Call all attributes.
	public String toString(){
		String output = "\nProject Number:\n\t" + projectNumber;
		output += "\nProject Name:\n\t" + projectName;
		output += "\nBuilding Type:\n\t" + buildingType;
		output += "\nBuilding Address:\n\t" + buildingAddress;
		output += "\nERF Number:\n\t" + erfNumber;
		output += String.format("\nTotal Fee:\n\tR%.2f", totalFee);
		output += String.format("\nATotal Paid:\n\tR%.2f", totalPaid);
		output += "\nDeadline:\n\t" + deadline;
		output += "\nArchitect:\n\t" + architect.getName();
		output += "\nContractor:\n\t" + contractor.getName();
		output += "\nCustomer:\n\t" + customer.getName();
		
		if (this.completed == false){
			output += "\nProject completed:\n\tNo";
		}
		else {
			output += "\nProject completed:\n\tYes";
		}
		output += "\n";
			
		return output;
	}
	
	// Add functionality to change project deadline.
	public void updateDeadline(Scanner numberInput){
		System.out.print("Please enter the year the project is due: ");
		int year = numberInput.nextInt();
		System.out.print("Please enter the month, using 1 for January to 12 for December, the project is due: ");
		int month = numberInput.nextInt();
		System.out.print("Please enter the day of the month the project is due: ");
		int day = numberInput.nextInt();
		this.deadline = LocalDate.of(year, month, day);
		System.out.println();
    }
	
	// Add functionality to change fee paid to date.
	public void updateTotalPaid(Scanner numberInput){
		System.out.print("How much is the customer paying into the account: ");
		float paid = numberInput.nextFloat();
		System.out.println();
		
		this.totalPaid += paid;
	}
	
	// Add functionality to update contractor details.
    public void updateContractor(Scanner input){
    	System.out.print("What is the contractors first name: ");
    	this.contractor.firstName = input.next();
    	
    	System.out.print("What is the contractors last name: ");
    	this.contractor.lastName = input.next();
    	
        System.out.print("What is the contractors phone number: ");
        this.contractor.phoneNumber = input.next();
        
        System.out.print("What is the contractors email address: ");
        this.contractor.email = input.next();
        
        System.out.print("What is the contractors address: ");
        this.contractor.address = input.next();
        
        System.out.println();
    }
    
    // Add functionality to finalize project.
    public void finalise(){
    	System.out.println();
    	this.completed = true;
    }

}