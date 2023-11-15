package training;

public class GuestHandler implements UserActions {
    private ContactList contactList;

    public GuestHandler(ContactList contactList) {
        this.contactList = contactList;
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

    // This function allow us to search for address in contactList.
     @Override
    public void searchByAddress(String streetName) {   // söka på address: söka på  (stad, postnummer, portnummer.

        for (Contact contact : contactList.getContacts()) {
            Address address = contact.getAddress();

            if (address.getStreetName().equalsIgnoreCase(streetName)) { // Söka på gatunamn.
                System.out.println(contact);
            }
        }
    }

    // // This function allow us to search for in contactList.
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
