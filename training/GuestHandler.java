package training;

public class GuestHandler implements UserActions {
    private ContactList contactList;

    public GuestHandler(ContactList contactList) {
        this.contactList = contactList;
    }

    // This function allow us to search for last name in contactList. 
    @Override
    public void searchByLastName(String lastName) {
        
        for (Contact contact : contactList.getContacts()) {
            
            if (contact.getLastName().equals(lastName)) {
                
                System.out.println(contact);
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

    // This function allow us to search for address in contactList.
    @Override
    public void searchByAddress(String address) {

        for (Contact contact : contactList.getContacts()) {
            
            if (contact.getAddress().equals(address)) {
                
                System.out.println(contact);
            }
        }
    }

    // // This function allow us to search for in contactList.
    @Override
    public void freestyleSearch(String searchFree) {

        for (Contact contact : contactList.getContacts()) {
            
            if (contact.getLastName().contains(searchFree) || contact.getFirstName().contains(searchFree) ||
                    contact.getAddress().contains(searchFree) || contact.getPhoneNumber().contains(searchFree)) {
                
                System.out.println(contact);
            }
        }
    }

}
