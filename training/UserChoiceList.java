package training;

import java.util.Scanner;


/** referenslista:
 * https://www.geeksforgeeks.org/string-in-switch-case-in-java/
 */

public class UserChoiceList {

        private static ContactList contactList = new ContactList();
        private static AdminHandler adminHandler = new AdminHandler(contactList);
        private static GuestHandler guestHandler = new GuestHandler(contactList);

        public static void main(String[] args) {

                Scanner input = new Scanner(System.in);
                String userInput;

                do {
                        mainMenu();
                        userInput = input.nextLine();

                        switch (userInput) {
                                case "1":
                                        handleGuestMenu(input);
                                        break;
                                case "2":
                                        handleAdminMenu(input);
                                        break;
                                case "quit":
                                        System.out.println("Exiting the program. Goodbye!");
                                        break;
                                default:
                                        System.out.println("Invalid input");
                                        break;
                        }
                } while (!userInput.equals("quit"));

        }

        private static void handleGuestMenu(Scanner input) {
                String userInput;

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
                } while (!userInput.equals("exit"));
        }
        private static void handleAdminMenu(Scanner input) {
                String userInput;

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
                                        System.out.println("Enter phone number of contact to update:");
                                        adminHandler.updateContact(input.nextLine(), input);
                                        break;
                                case "7":
                                        System.out.println("Enter phone number of contact to delete:");
                                        adminHandler.deleteContact(input.nextLine());
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
                } while (!userInput.equals("exit"));
        }

        private static void mainMenu() {
                System.out.println("MAIN MENU");
                System.out.println("1: Guest");
                System.out.println("2: Admin");
                System.out.println("Type 'quit' to exit the program");
                System.out.print("Enter your selection: ");
        }

        private static void guestMenu() {
                System.out.println("GUEST MENU");
                System.out.println("1: Search for last name");
                System.out.println("2: Search for first name");
                System.out.println("3: Search for address");
                System.out.println("4: Freestyle search");
                System.out.println("Type 'exit' to return to the main menu");
                System.out.print("Enter your choice: ");
        }

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
