package training;

import java.util.Scanner;

/**
 * Referens:
 * https://www.geeksforgeeks.org/crud-operations-in-student-management-system-in-java/#
 */

public class AdminHandler implements UserActions {
    private ContactList contactList;

    // Constructor updated to accept ContactList
    public AdminHandler(ContactList contactList) {
        this.contactList = contactList;
    }

    // Add contact
    public void addContact(Scanner input) {
        System.out.println("Enter last name: ");
        String lastName = input.nextLine();
        System.out.println("Enter first name: ");
        String firstName = input.nextLine();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        input.nextLine(); // Consume the newline character
        System.out.println("Enter address: ");
        String address = input.nextLine();
        System.out.println("Enter phone number: ");
        String phoneNumber = input.nextLine();

        Contact newContact = new Contact(lastName, firstName, age, address, phoneNumber);
        add(newContact);
    }

    private void add(Contact contact) {

        if (!find(contact.getPhoneNumber())) {
            contactList.getContacts().add(contact);
            System.out.println("Contact added successfully!");
        } else {
            System.out.println("Contact already exists in the contact list");
        }
    }

    private boolean find(String phoneNumber) {

        for (Contact contact : contactList.getContacts()) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    public void deleteContact(String phoneNumber) {
        Contact contactDel = findContact(phoneNumber);

        if (contactDel != null) {
            contactList.getContacts().remove(contactDel);
            System.out.println("Contact successfully removed from list");
        } else {
            System.out.println("Contact with the given phone number not found");
        }
    }

    private Contact findContact(String phoneNumber) {

        for (Contact contact : contactList.getContacts()) {

            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void updateContact(String phoneNumber, Scanner input) {
        Contact contactToUpdate = findContact(phoneNumber);

        if (contactToUpdate != null) {
            System.out.println("Enter new last name: ");
            contactToUpdate.setLastName(input.nextLine());
            System.out.println("Enter new first name: ");
            contactToUpdate.setFirstName(input.nextLine());
            System.out.println("Enter new age: ");
            contactToUpdate.setAge(input.nextInt());
            input.nextLine(); // Consume newline
            System.out.println("Enter new address: ");
            contactToUpdate.setAddress(input.nextLine());
            System.out.println("Enter new phone number: ");
            contactToUpdate.setPhoneNumber(input.nextLine());

            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    public void displayContacts() {
        if (contactList.getContacts().isEmpty()) {
            System.out.println("The list has no contacts.");
        } else {
            System.out.println("List of Contacts:");
            for (Contact contact : contactList.getContacts()) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void searchByLastName(String lastName) {
        for (Contact contact : contactList.getContacts()) {
            if (contact.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void searchByFirstName(String firstName) {

        for (Contact contact : contactList.getContacts()) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void searchByAddress(String address) {

        for (Contact contact : contactList.getContacts()) {
            if (contact.getAddress().equalsIgnoreCase(address)) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void freestyleSearch(String searchTerm) {

        for (Contact contact : contactList.getContacts()) {
            if (contact.getLastName().contains(searchTerm) || contact.getFirstName().contains(searchTerm) ||
                    contact.getAddress().contains(searchTerm) || contact.getPhoneNumber().contains(searchTerm)) {
                System.out.println(contact);
            }
        }
    }
}
