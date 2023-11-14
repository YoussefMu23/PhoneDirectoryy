package training;

/** referens:
 * https://www.w3schools.com/java/java_interface.asp
 */
public interface UserActions {
    
    void searchByLastName(String lastName);
   
    void searchByFirstName(String firstName);
    
    void searchByAddress(String address);
    
    void freestyleSearch(String searchTerm);
}
