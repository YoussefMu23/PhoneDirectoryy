package training;

import java.util.Scanner;



public class UserChoiceList {

        private static ContactList contactList = new ContactList(); // Instantiating ContactList
        
        private static AdminHandler adminHandler = new AdminHandler(contactList); // Instantiating admin handling 
        
        private static GuestHandler guestHandler = new GuestHandler(contactList); // Instantiating guest handling

        public static void main(String[] args) {

                Scanner input = new Scanner(System.in); // Scanner input created 
                
                String userInput;         // Create variable userInput

                // do - while loop 
                do {
                        mainMenu();
                        userInput = input.nextLine();         // store the user input in userInput variable 


                        /** referenslista:
                         * https://www.geeksforgeeks.org/string-in-switch-case-in-java/
                        */
                        switch (userInput) {
                                case "1":
                                        handleGuestMenu(input);
                                        break;
                                case "2":
                                        boolean correctPassword;

                                        System.out.println("Enter password: ");
                                        String password = input.nextLine();

                                        if (password.equals("123456")) {
                                                correctPassword = true;
                                        } else {
                                                correctPassword=false;
                                                System.out.println("Invalide password");
                                                break;
                                        }
                                        
                                        handleAdminMenu(input);
                                        break;
                                case "quit":
                                        System.out.println("Exiting the program. Goodbye!");
                                        break;
                                default:
                                        System.out.println("Invalid input");
                                        break;
                        }
                } while (!userInput.equals("quit")); // when userinput equals to quit, the do while will quit and the program will also quit. 

        }

       
        
        private static void handleGuestMenu(Scanner input) {
                String userInput;

                // do while - loop
                do {
                        guestMenu();
                        userInput = input.nextLine();

                        switch (userInput) {
                                case "1":
                                        System.out.println("Enter last name to search: ");
                                        guestHandler.searchByLastName(input.nextLine());
                                        break;
                                case "2":
                                        System.out.println("Enter first name to search: ");
                                        guestHandler.searchByFirstName(input.nextLine());
                                        break;
                                case "3":
                                        System.out.println("Enter address to search: ");
                                        guestHandler.searchByAddress(input.nextLine());
                                        break;
                                case "4":
                                        System.out.println("Enter search term for freestyle search: ");
                                        guestHandler.freestyleSearch(input.nextLine());
                                        break;
                                case "exit":
                                        System.out.println("Exiting Guest Menu.");
                                        break;
                                default:
                                        System.out.println("Invalid input in Guest Menu");
                                        break;
                        }
                } while (!userInput.equals("exit")); // exit the do while when the input equals to exit.
        }
       
        
        private static void handleAdminMenu(Scanner input) {
                String userInput;

                // do while - loop
                do {
                        adminMenu();
                        userInput = input.nextLine();

                        switch (userInput) {
                                case "1":
                                        System.out.println("Enter last name to search:");
                                        adminHandler.searchByLastName(input.nextLine());
                                        break;
                                case "2":
                                        System.out.println("Enter first name to search:");
                                        adminHandler.searchByFirstName(input.nextLine());
                                        break;
                                case "3":
                                        System.out.println("Enter address to search:");
                                        adminHandler.searchByAddress(input.nextLine());
                                        break;
                                case "4":
                                        System.out.println("Enter search term for freestyle search:");
                                        adminHandler.freestyleSearch(input.nextLine());
                                        break;
                                case "5":
                                        adminHandler.addContact(input);
                                        break;
                                case "6":
                                        System.out.println("Enter last name of contact to update:");
                                        String lastNameUpdate = input.nextLine();

                                        System.out.println("Enter first name of contact to update:");
                                        String firstNameUpdate = input.nextLine();
                                        adminHandler.updateContact(lastNameUpdate, firstNameUpdate, input);
                                        break;
                                case "7":
                                        System.out.println("Enter last name of contact to update:");
                                        String lastNameDelete = input.nextLine();

                                        System.out.println("Enter first name of contact to update:");
                                        String firstNameDelete = input.nextLine();
                                        adminHandler.deleteContact(lastNameDelete, firstNameDelete);
                                        break;
                                case "8":
                                        adminHandler.displayContacts();
                                        break;
                                case "exit":
                                        System.out.println("Exiting Admin Menu.");
                                        break;
                                default:
                                        System.out.println("Invalid input in Admin Menu");
                                        break;
                        }
                } while (!userInput.equals("exit")); // // exit the do while when the input equals to exit.
        }

        // This shows up the main Menu
        private static void mainMenu() {
                System.out.println("MAIN MENU");
                System.out.println("1: Guest");
                System.out.println("2: Admin");
                System.out.println("Type 'quit' to exit the program");
                System.out.print("Enter your selection: ");
        }


        //This shows up the guest Menu
        private static void guestMenu() {
                System.out.println("GUEST MENU");
                System.out.println("1: Search for last name");
                System.out.println("2: Search for first name");
                System.out.println("3: Search for address");
                System.out.println("4: Freestyle search");
                System.out.println("Type 'exit' to return to the main menu");
                System.out.print("Enter your choice: ");
        }

        //This shows up the admin Menu
        private static void adminMenu() {
                System.out.println("ADMIN MENU");
                System.out.println("1: Search for last name");
                System.out.println("2: Search for first name");
                System.out.println("3: Search for address");
                System.out.println("4: Freestyle search");
                System.out.println("5: Add contact");
                System.out.println("6: Update contact");
                System.out.println("7: Delete contact");
                System.out.println("8: Display all contacts");
                System.out.println("9: Type exit to exit to main menu");
                System.out.print("Enter your choice: ");
    }




}
