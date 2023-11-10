package training;

import java.util.Scanner;

public class UserChoiceList {

    static AdminHandler adminHandler = new AdminHandler();

    static GuestHandler guestHandler = new GuestHandler();


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput;


        do {
            mainMenu();

            userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    // Guest
                    handleGuestMenu(input, guestHandler);
                    break;
                case "2":
                    // Admin
                    handleAdminMenu(input, adminHandler);
                    break;
                case "9":
                    System.out.println("Returning to the main menu.");
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

    public static void handleGuestMenu(Scanner input ,  GuestHandler guestHandler) {
        String userInput;

        guestMenu();
        do {

            userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println("Search for lastname ?, Option 1");
                    String lastName = input.next();
                    guestHandler.searchByLastName(lastName);
                    break;
                case "2":
                    System.out.println("Search for firstname, Option 2");
                    String firstName = input.next();
                    guestHandler.searchByFirstName(firstName);
                    break;
                case "3":
                    System.out.println("Enter address to search, Option 3");
                    String address = input.next();
                    guestHandler.searchByAddress(address);
                    break;
                case "4":
                    System.out.println("Enter a search term/freestyle, Option 4");
                    String searchTerm = input.next();
                    guestHandler.freestyleSearch(searchTerm);
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

    public static void handleAdminMenu(Scanner input, AdminHandler adminHandler) {
        String userInput;




        do {
            adminMenu();
            userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    System.out.println("Enter last name to search:, Option 1");
                    String lastName = input.next();
                    adminHandler.searchByLastName(lastName);
                    break;
                case "2":
                    System.out.println("Search for first name, Option 2");
                    String firstName = input.next();
                    adminHandler.searchByFirstName(firstName);
                    break;
                case "3":
                    System.out.println("Enter address to search, Option 3");
                    String address = input.next();
                    adminHandler.searchByAddress(address);
                    break;
                case "4":
                    System.out.println("Enter a search freestyle/term, Option 4");
                    String searchTerm = input.next();
                    adminHandler.freestyleSearch(searchTerm);
                    break;
                case "5":
                    System.out.println("Add contact, Option 5");
                    adminHandler.addContact(input, adminHandler);
                    break;
                case "6":
                    System.out.println("Enter phone number of contact to update, Option 6");
                    input.nextLine(); // Consume the newline character
                    String phoneNumberToUpdate = input.nextLine(); // Read the phone number
                    adminHandler.update(phoneNumberToUpdate, input);
                    break;
                case "7":
                    System.out.println("Enter phone number of contact to delete, Option 7");
                    String contactPhoneNumber = input.next();
                    adminHandler.deleteContact(contactPhoneNumber);
                    break;

                case "8":
                    System.out.println("Display contacts: ");
                    adminHandler.display();
                    break;
                case "exit":
                    System.out.println("Exiting Admin Menu.");
                    break;

                default:
                    System.out.println("Invalid input in Admin Menu");
                    break;
            }
        } while (!userInput.equals("quit"));
    }

    public static void mainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1: Guest");
        System.out.println("2: Admin");
        System.out.println("Type 'quit' to exit the program");
        System.out.print("Enter your selection: ");
    }

    public static void guestMenu() {
        System.out.println("GUEST");
        System.out.println("1: Search for last name");
        System.out.println("2: Search for first name");
        System.out.println("3: Search for address");
        System.out.println("4: Freestyle search");
        System.out.println("9: Type exit to exit to main menu");
        System.out.print("Enter your choice: ");
    }

    public static void adminMenu() {
        System.out.println("ADMIN");
        System.out.println("1: Search for last name");
        System.out.println("2: Search for first name");
        System.out.println("3: Search for address");
        System.out.println("4: Freestyle search");
        System.out.println("5: Add contact");
        System.out.println("6: Update contact");
        System.out.println("7: Delete contact");
        System.out.println("8: Display list");
        System.out.println("9: Type exit to exit to main menu");
        System.out.print("Enter your choice: ");
    }




}

