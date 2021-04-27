package package1;

import java.util.Scanner;

public class FirstClassProject {
	
	public static void searchUserProfile(Scanner input, FileHandler file) {
		System.out.println("Searching UserProfile...");
		System.out.println("Enter FirstName: ");
		String firstName = input.next();		
		System.out.println("Enter LastName: ");
		String lastName = input.next();	
		UserProfile userProfile = file.readObjectfromFile(firstName.toUpperCase()+lastName.toUpperCase()+".txt");
		if (userProfile.getFirstName()!=null) {
			System.out.println("UserProfile found: " + userProfile.toString());
		} else {
			System.out.println("UserProfile NOT found...");
		}	
	}
		
	
	public static void deleteUserProfile(Scanner input, FileHandler file) {
		System.out.println("Deleting UserProfile...");
		System.out.println("Enter FirstName: ");
		String firstName = input.next();		
		System.out.println("Enter LastName: ");
		String lastName = input.next();	
		UserProfile oldUserProfile = file.readObjectfromFile(firstName.toUpperCase()+lastName.toUpperCase()+".txt");
		if (oldUserProfile.getFirstName()!=null) {
			System.out.println("Current UserProfile Contents: " + oldUserProfile.toString());
			System.out.println("Please confirm if you want to delete: ");
			String confirm = input.next();		
			if (confirm.toUpperCase().contains("Y")) {
				file.deleteFile("C:/Users/newco/Documents/temporary/"+firstName.toUpperCase()+lastName.toUpperCase()+".txt");
				System.out.println("UserProfile deleted: " + oldUserProfile.toString());
			} else {
				System.out.println("UserProfile NOT deleted: " + oldUserProfile.toString());
			}	
		} else {
			System.out.println("UserProfile FileName Not Found: "+firstName.toUpperCase()+lastName.toUpperCase()+".txt");
		}
	}
	
	public static void updateUserProfile(Scanner input, FileHandler file) {
		System.out.println("Updating UserProfile...");
		System.out.println("Enter FirstName: ");
		String firstName = input.next();		
		System.out.println("Enter LastName: ");
		String lastName = input.next();	
		UserProfile oldUserProfile = file.readObjectfromFile(firstName.toUpperCase()+lastName.toUpperCase()+".txt");
		if (oldUserProfile.getFirstName()!=null) {		
			System.out.println("Enter New EmailID: ");
			String emailid = input.next();		
			System.out.println("Enter New UserID: ");
			String userid = input.next();
			System.out.println("Enter New Password: ");
			String password = input.next();
			UserProfile newUserProfile = new UserProfile(oldUserProfile.getFirstName(), oldUserProfile.getLastName(), emailid, userid,password);
			file.writeObjectIntoFile("C:/Users/newco/Documents/temporary/"+firstName.toUpperCase()+lastName.toUpperCase()+".txt", newUserProfile);
			System.out.println("UserProfile updated: " + newUserProfile.toString());	
		} else {
			System.out.println("UserProfile FileName Not Found: "+firstName.toUpperCase()+lastName.toUpperCase()+".txt");
		}			
	}
		

	public static void createUserProfile(Scanner input, FileHandler file) {
		System.out.println("Adding UserProfile...");
		System.out.println("Enter FirstName: ");
		String firstname = input.next();
		System.out.println("Enter LastName: ");
		String lastname = input.next();
		System.out.println("Enter EmailID: ");
		String emailid = input.next();		
		System.out.println("Enter UserID: ");
		String userid = input.next();
		System.out.println("Enter Password: ");
		String password = input.next();
		UserProfile userProfile = new UserProfile(firstname, lastname, emailid, userid,password);
		file.writeObjectIntoFile("C:/Users/newco/Documents/temporary/"+firstname.toUpperCase()+lastname.toUpperCase()+".txt", userProfile);
		System.out.println("UserProfile added: " + userProfile.toString());		
	}
	
	
	public static void main(String[] args) {

		try {
			boolean done = false;
			do {
				FileHandler fileHandler = new FileHandler();
				System.out.println(); System.out.println();				
				System.out.println("****************************************************************");
				System.out.println("*********************  user profile screen  ********************");
				System.out.println("****************************************************************");
				System.out.println();
				System.out.println(" 1. New UserProfile Contents");
				System.out.println(" 2. Edit UserProfile Contents");
				System.out.println(" 3. Delete UserProfile FileName");
				System.out.println(" 4. Display All UserProfiles FileName ");
				System.out.println(" 5. Display UserProfile contents ");				
				System.out.println(" 6. Exit ");
				System.out.println();
				System.out.println("Enter Your Choice:");
				Scanner input = new Scanner(System.in);
				Integer num = input.nextInt(); 

				switch (num) {
				case 1:
					createUserProfile(input,fileHandler);
					break;
				case 2:
					updateUserProfile(input,fileHandler);
					break;
				case 3:
					deleteUserProfile(input,fileHandler);
					break;
				case 4:
					System.out.println("Displaying All UserProfile...");
					fileHandler.displayAllFiles("C:/Users/newco/Documents/temporary/");
					break;
				case 5:
					searchUserProfile(input,fileHandler);
					break;
				case 6:
					System.out.println("Exiting...");
					done = true;
					input.close();
					break;
				}
				
			} while (!done);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}