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
    /*
     *  Initialize bank with customers and accounts empty 
     */
    public Bank(){
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
    }

    //METHODS-----------------------------------------
    //Getters
    /**
     * Returns the accounts list.
     * @return accounts list.
     */
    public ArrayList<CheckingAccount> getAccounts() {
        return accounts;
    }

    //Other methods
    /**
     * Adds customer pPerson to list.
     * @param pPerson customer to add.
     */
    public void addCustomer(Person pPerson){
        customers.add(pPerson);
    }

    /**
     * Adds account pAccount to list.
     * @param pAccount account to add.
     */
    public void addAccount(CheckingAccount pAccount){
        accounts.add(pAccount);
    }
    
    /**
     * Looks for a customer by its number.
     * @param pNumber social security number of customer user is looking for.
     * @return A customer with social security number pNumber. Null if it is not found.
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

    /**
     * Looks for an account by its number.
     * @param pNumber number of account user is looking for.
     * @return An account with number pNumber. Null if it is not found.
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
