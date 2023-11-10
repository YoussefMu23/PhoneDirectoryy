package training;

import java.util.LinkedList;
import java.util.Scanner;





//Class

/// denna är tillagd
public class AdminHandler implements UserActions{



    //Creating en empty LinkedList
    private LinkedList<Contact> list;


    public AdminHandler() {
        list = new LinkedList<>();

    }


    // Add contact
    public void add(Contact contact) {
        if (!find(contact.getPhoneNumber())) {
            list.add(contact);
        } else {
            System.out.println("Contact with this phone number already exists.");
        }
    }

    public boolean find(String phoneNumber) {

        for (Contact l : list) {
            // Checking if Conctact by phoneNumber
            if (l.getPhoneNumber().equals(phoneNumber))

                System.out.println(l);
            return true;
        }
        return false;
    }

    // Delete Register
    public void delete(String contPhoneNumber) {

        Contact contactDel = null;

        // Iterating record list
        for (Contact ll : list) {
            // Finding Contact to delete by phoneNumber
            if (ll.getPhoneNumber() == contPhoneNumber) {
                contactDel = ll;
            }
        }

        // If contactDel is null, show error message.
        // else remove the contact from the contact list
        if (contactDel == null) {
            // Display no contact found
            System.out.println("Invalid contact phone number");
        } else {

            list.remove(contactDel);
            //Display message for succesful deletion of contact
            System.out.println("Successfully removed contact from list");
        }
    }

    //Find contact
    // phone Number

    public Contact findContact(String phoneNumber) {
        //Iterate Contact list
        // using for each loop
        for (Contact l : list) {

            //Checking record by phone Number
            if (l.getPhoneNumber().equals(phoneNumber)) {
                return l;
            }
        }

        return null;
    }

    //Update Contact

    public void update(String number, Scanner input) {

        if (find(number)) {
            Contact con = findContact(number);

            //Display message only
            System.out.println("What is the new Contact phone number?");
            String phoneNumber = input.nextLine();

            //Display message only
            System.out.println("What is the new Contact last name?");
            String lastName = input.nextLine();

            //Display message only
            System.out.println("What is the new Contact first name?");
            String firstName = input.nextLine();

            //Display message only
            System.out.println("What is the new Contact age?");
            int age = input.nextInt();

            //Display message only
            System.out.println("What is the new Contact address?");
            String address = input.nextLine();

            con.setPhoneNumber(phoneNumber);
            con.setLastName(lastName);
            con.setFirstName(firstName);
            con.setAge(age);
            con.setAddress(address);
            System.out.println("Contact updated Successfully");

        }

        else {
            System.out.println("Contact not found in the Contact list");


        }
    }










    public void deleteContact(String contPhoneNumber) {
        Contact contactDel = null;
        for (Contact ll : list) {
            if (ll.getPhoneNumber().equals(contPhoneNumber)) {
                contactDel = ll;
            }
        }
        if (contactDel == null) {
            System.out.println("Invalid contact phone number");
        } else {
            list.remove(contactDel);
            System.out.println("Successfully removed contact from list");
        }
    }




    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list has no contacts");
        } else {
            System.out.println("List of Contacts:");
        }
        for (Contact contact : list) {
            System.out.println(contact);
        }
    }

    @Override
    public void searchByLastName(String lastName) {
        for (Contact contact : list) {
            if (contact.getLastName().equals(lastName)) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void searchByFirstName(String firstName) {
        for (Contact contact : list) {
            if (contact.getFirstName().equals(firstName)) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void searchByAddress(String address) {
        for (Contact contact : list) {
            if (contact.getAddress().equals(address)) {
                System.out.println(contact);
            }
        }
    }

    @Override
    public void freestyleSearch(String searchTerm) {
        for (Contact contact : list) {
            if (contact.getLastName().contains(searchTerm) || contact.getFirstName().contains(searchTerm)
                    || contact.getAddress().contains(searchTerm) || contact.getPhoneNumber().contains(searchTerm)) {
                System.out.println(contact);
            }
        }
    }

    public  void addContact(Scanner input, AdminHandler admin) {
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter age: ");
        int age = input.nextInt();
        System.out.println("Enter address: ");
        String address = input.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = input.next();

        Contact newContact = new Contact(lastName, firstName, age, address, phoneNumber);
        admin.add(newContact);

        System.out.println("Contact added successfully!");
    }




}
