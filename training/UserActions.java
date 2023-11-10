package training;

public interface UserActions {
    void searchByLastName(String lastName);
    void searchByFirstName(String firstName);
    void searchByAddress(String address);
    void freestyleSearch(String searchTerm);
}