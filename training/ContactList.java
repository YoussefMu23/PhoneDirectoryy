package training;

import java.util.LinkedList;

public class ContactList {
    private LinkedList<Contact> contacts;

    public ContactList() {
        contacts = new LinkedList<>();
    }

    public LinkedList<Contact> getContacts() {
        return contacts;
    }
}
