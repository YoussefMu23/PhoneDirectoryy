package training;

public class GuestHandler implements UserActions {
    private ContactList contactList;

    public GuestHandler(ContactList contactList) {
        this.contactList = contactList;
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
    public void freestyleSearch(String freeSearch) {

        for (Contact contact : contactList.getContacts()) {
            if (contact.getLastName().contains(freeSearch) || contact.getFirstName().contains(freeSearch) ||
                    contact.getAddress().contains(freeSearch) || contact.getPhoneNumber().contains(freeSearch)) {
                System.out.println(contact);
            }
        }
    }


}
