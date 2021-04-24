package package1;

import java.util.Scanner;

public class FirstClassProject {

	public static void main(String[] args) {

		try {
			boolean done = false;
			do {
				FileHandler fileHandler = new FileHandler();
				System.out.println("****************************************************************");
				System.out.println("*********************  user profile screen  ********************");
				System.out.println("****************************************************************");
				System.out.println();
				System.out.println(" 1. New UserProfile ");
				System.out.println(" 2. Edit UserProfile ");
				System.out.println(" 3. Delete UserProfile ");
				System.out.println(" 4. Display All UserProfiles ");
				System.out.println(" 5. Search UserProfile  ");
				System.out.println(" 6. Read UserProfile From File ");
				System.out.println(" 7. Exit ");
				System.out.println();
				System.out.println("Enter Your Choice:");
				Scanner input = new Scanner(System.in);
				Integer num = input.nextInt();

				switch (num) {
				case 1:
					System.out.println("Adding UserProfile...");
					UserProfile userProfile1 = new UserProfile("Roel", "Mendoza", "roelmendoza1@gmail.com", "ramendoz1",
							"password1");
					fileHandler.writeObjectIntoFile("C:/Users/newco/Documents/temporary/RoelMendoza.txt", userProfile1);
					break;
				case 2:
					System.out.println("Editing UserProfile...");
					UserProfile userProfile2 = new UserProfile("Roel", "Mendoza", "roelmendoza2@gmail.com", "ramendoz2",
							"password2");
					fileHandler.updateObjectIntoFile("C:/Users/newco/Documents/temporary/RoelMendoza.txt", userProfile2);
					break;
				case 3:
					System.out.println("Deleting UserProfile...");
					fileHandler.deleteFile("C:/Users/newco/Documents/temporary/RoelMendoza.txt");
					break;
				case 4:
					System.out.println("Displaying All UserProfile...");
					fileHandler.displayAllFiles("C:/Users/newco/Documents/temporary/");
					break;
				case 5:
					System.out.println("Searching UserProfile...");
					fileHandler.searForFilename("C:/Users/newco/Documents/temporary/", "RoelMendoza.txt");
					break;
				case 6:
					System.out.println("Reading UserProfile From File...");
					fileHandler.readObjectfromFile("C:/Users/newco/Documents/temporary/RoelMendoza.txt");
					break;
				case 7:
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