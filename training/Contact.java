package training;

public class Contact {

    //Instance variables
    private String lastName;
    private String firstName;
    private int age;
    private Address address;
    private String phoneNumber;

    //  Default Constructor
    public  Contact() {



    }


    public Contact (String lastName, String firstName, int age , Address address , String phoneNumber) {
        //Keyword refers to current instance variable
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    // Getting the value of lastName and return value of lastName
    public String getLastName() {
        return lastName;
    }
    // Set the value of lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getting the value of firstName and return value of firstName
    public String getFirstName() {
        return firstName;
    }
    // Set the value of firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getting the value of age and return value of age
    public int getAge() {
        return age;
    }
    // Set the value of age
    public void setAge(int age) {
        this.age = age;
    }

    // Getting the value of address and return value of address
    public Address getAddress() {
        return address;
    }
    // Set the value of address
    public void setAddress(Address address) {
        this.address = address;
    }

    // Getting the value of phoneNumber and return value of phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }
    // Set the value of phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //toString method
    @Override
    public String toString() {
        // Returning Conctact
        return "Contact{"
                + "lastName = " + lastName + ", firstName = " + firstName
                + ", age = " + age +  address + ", phoneNumber = " + phoneNumber + '}';


    }






}
