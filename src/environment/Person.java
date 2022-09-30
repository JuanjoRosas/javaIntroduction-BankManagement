package environment;

public class Person {//Represents a person who may be the owner of one or several accounts.
    //ATRIBUTES------------------------------------
    /*
     * First name of person.
     */
    private String firstName;

    /*
     * Middle name of person.
     */
    private String middleName;

    /*
     * Last name of person
     */
    private String lastName;

    /*
     * Social security number of person
     */
    private String socialSecurityNumber;

    //CONSTRUCTOR------------------------------------
    /*
     * Initializes the values ​​of the Class' attributes.
     */
    public Person(String pFirstName, String pMiddleName, String pLastName, String pSocialNumber){
        firstName = pFirstName;
        middleName = pMiddleName;
        lastName = pLastName;
        socialSecurityNumber = pSocialNumber;
    }

    //METHODS----------------------------------------
    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    //Getters
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

}
