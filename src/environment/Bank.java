package environment;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    //CONSTANTS------------------------------------
    /*
     * Minimun initial deposit
     */
    public final static double MINIMUM_INITIAL_DEPOSIT = 1000;

    /*
     * Maximum withdrawal ammount
     */
    public final static double MAXIMUM_WITHDRAWAL = 100000;

    //ATRIBUTES------------------------------------
    /*
     * Customers that have oppened at least one account in any time
     */
    private ArrayList<Person> customers;

    /*
     * Active checking accounts in bank
     */
    private ArrayList<CheckingAccount> accounts;

    //CONSTRUCTOR-----------------------------------
    public Bank(){
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    //METHODS-----------------------------------------
    /*
     * Creates a new customer and adds it to list
     */
    public void createCustomer(String pFirstName, String pMiddleName, String pLastName, String pSocialNumber){
        Person addPerson = new Person(pFirstName, pMiddleName, pLastName, pSocialNumber);
        customers.add(addPerson);
    }

    /*
     * Adds an account to list
     */
    public void addAccount(CheckingAccount pAccount){
        accounts.add(pAccount);
    }
    
    /*
     * Search for a customer by its social security number.
     * If it is not found returns null.
     */
    public Person searchCustomer(String pNumber){
        Person found = null;
        Person curPerson;
        int customersLength = customers.size();
        for(int i = 0; i < customersLength && found == null; i++){
            curPerson = customers.get(i);
            if(curPerson.getSocialSecurityNumber().equalsIgnoreCase(pNumber))
                found = curPerson;
        }
        return found;
    }

    /*
     * Search for an account by its number.
     * If it is not found returns null.
     */
    public CheckingAccount searchAccount(String pNumber){
        CheckingAccount found = null;
        CheckingAccount curAccount;
        int accountsLength = accounts.size();
        for(int i = 0; i < accountsLength && found == null; i++){
            curAccount = accounts.get(i);
            if(curAccount.getNumber().equalsIgnoreCase(pNumber))
                found = curAccount;
        }
        return found;
    }

}
