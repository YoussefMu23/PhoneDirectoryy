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

    // Register contact
   // Add contact
    public void addContact(Scanner input) {

        System.out.println("Enter last name: ");
        String lastName = input.nextLine();

        System.out.println("Enter first name: ");
        String firstName = input.nextLine();

        System.out.println("Enter age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.println("Address: ");
        System.out.println("Enter street name: ");
        String streetName = input.nextLine();

        System.out.println("Enter city: ");
        String city = input.nextLine();

        System.out.println("Enter post code: ");
        String postCode = input.nextLine();

        System.out.println("Enter port number: ");
        String portNumber = input.nextLine();

        System.out.println("Enter phone number: ");
        String phoneNumber = input.nextLine();

        Address address = new Address(streetName,city, postCode, portNumber);
        Contact newContact = new Contact(lastName, firstName, age, address, phoneNumber);
        add(newContact);

    }

    // adds the contact to the contactlist
    private void add(Contact contact) {

        if (!find(contact.getPhoneNumber())) {
            
            contactList.getContacts().add(contact);
            System.out.println("Contact added successfully!");
        } else {
            
            System.out.println("Contact already exists in the contact list");
        }
    }

    // looks for phoneNumber in the conctact
    private boolean find(String phoneNumber) {

        for (Contact contact : contactList.getContacts()) {
            
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    // Delete Contact from contactList
    public void deleteContact(String phoneNumber) {
        Contact contactDel = findContact(phoneNumber);

        if (contactDel != null) {
            
            contactList.getContacts().remove(contactDel);
            System.out.println("Contact successfully removed from list");
        } else {
            
            System.out.println("Contact with the given phone number not found");
        }
    }


    // looks for contact in the contact list with help of phone number
    private Contact findContact(String phoneNumber) {

        for (Contact contact : contactList.getContacts()) {

            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    // Update the Contact, findContact looks up phoneNumber first
 public void updateContact(String phoneNumber, Scanner input) {

        Contact contactToUpdate = findContact(phoneNumber);

        if (contactToUpdate != null) {
            System.out.println("Enter new last name: ");
            contactToUpdate.setLastName(input.nextLine());

            System.out.println("Enter new first name: ");
            contactToUpdate.setFirstName(input.nextLine());

            System.out.println("Enter new age: ");
            contactToUpdate.setAge(input.nextInt());
            input.nextLine();

            System.out.println("Address: ");

            System.out.println("Enter new street name: ");
            String newStreetName = input.nextLine();

            System.out.println("Enter new city: ");
            String newCity = input.nextLine();

            System.out.println("Enter new post code: ");
            String newPostCode = input.nextLine();

            System.out.println("Enter new port number: ");
            String newPortNumber = input.nextLine();
            // Create new address object
            Address newAddress = new Address(newStreetName, newCity, newPostCode, newPortNumber);
            // set new address to Contact
            contactToUpdate.setAddress(newAddress);

            System.out.println("Enter new phone number: ");
            contactToUpdate.setPhoneNumber(input.nextLine());

            System.out.println("Contact updated successfully!");
        } else {

            System.out.println("Contact not found.");
        }

    }


    // Shows the Contact if is empty else it shows the contactList
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

    // This function allow us to search for last name in contactList. 
  @Override
    public void searchByLastName(String lastName) { // första matchingen ska ändast visas, asvsluta loppen när lastNamn är hittat.

        for (Contact contact : contactList.getContacts()) {

            if (contact.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(contact);
                break;
            }
        }
    }

    // This function allow us to search for first name in contactList.
    @Override
    public void searchByFirstName(String firstName) {

        for (Contact contact : contactList.getContacts()) {
            
            if (contact.getFirstName().equals(firstName)) {
                
                System.out.println(contact);
            }
        }
    }

    // This function allow us to search for street name in contactlist.
   @Override
    public void searchByAddress(String streetName) {   

        for (Contact contact : contactList.getContacts()) {
            Address address = contact.getAddress();

            if (address.getStreetName().equalsIgnoreCase(streetName)) { 
                System.out.println(contact);
            }
        }
    }

    // This function allow us to make a free search in contactList. U can search for lastname, first name, streetname and phone number. 
    @Override
    public void freestyleSearch(String freeSearch) {

        for (Contact contact : contactList.getContacts()) {
            Address address = contact.getAddress();

            if (contact.getLastName().contains(freeSearch.toLowerCase()) || contact.getFirstName().contains(freeSearch.toLowerCase()) ||
                    address.getStreetName().contains(freeSearch.toLowerCase()) || contact.getPhoneNumber().contains(freeSearch.toLowerCase())) {

                System.out.println(contact);
            }
        }
    }
}
