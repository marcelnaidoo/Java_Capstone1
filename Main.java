import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Declare variables.
		boolean dontExit = true;
		// Error encountered when entering text with a space.
		// useDelimiter("\\n") method resolves this issue.
		Scanner input = new Scanner(System.in).useDelimiter("\\n");
		Scanner numberInput = new Scanner(System.in);
		
		// Create new project object.
		ProjectDetails addProject = new ProjectDetails(input, numberInput);
		System.out.println();
		
		// Loop through program until user decides to exit.
		while(dontExit){
			System.out.println("Please select an option from the menu below");
			System.out.println("1:Change the due date of a project");
			System.out.println("2:Pay into a project");
			System.out.println("3:Update a contractors details");
			System.out.println("4:Finalise a project");
			System.out.println("5:Display project details");
			System.out.println("0:Quit\n");
			int choice = numberInput.nextInt();
			
			// Close the scanner and quit program.
			if (choice == 0){
				input.close();
				System.out.println("Thank you, project exited");
				dontExit = false;
			}
			
			// Change project due date.
			else if (choice == 1){
				addProject.updateDeadline(numberInput);
			}
			
			// Pay into project.
			else if (choice == 2){
				addProject.updateTotalPaid(numberInput);
			}
			
			// Update contractor details.
			else if (choice == 3){
				addProject.updateContractor(input);
			}
			
			// Finalize the project.
			else if (choice == 4){
				addProject.finalise();
			}
			
			// Display project details.
			else if (choice == 5){
				System.out.println(addProject.toString());
			}
			
			else{
				System.out.printf("Your input '%s' does not match a menu item, please try again\n\n", choice);
			}
		}

	}

}