package main;

import java.util.Scanner;

import environment.Bank;
import environment.CheckingAccount;
import environment.Person;

public class App {
    public static void main(String[] args) throws Exception {
        //Run app
        Bank bank = new Bank();
        Scanner reader = new Scanner(System.in);
        String strAction = "";
        boolean action = true;

        System.out.println("Welcome to bank management system");

        while(true){
            System.out.println("What do you want to do? (createCustomer/createAccount/deposit/withdrawal/exit)");
            strAction = reader.next();
            action = doAction(strAction, reader, bank);
            if(action == false)
                break;
        }
        System.out.println("Goode bye!");
        reader.close();
    }

    /*
     * Evaluates which action to do
     */
    public static boolean doAction(String pAction, Scanner pReader, Bank pBank){
        /* 
         * Action create customer
         */
        final String ACTION_CREATE_CUSTOMER = "createCustomer";

        /*
         * Action create account
         */
        final String ACTION_CREATE_ACCOUNT = "createAccount";

        /*
         * Action deposit
         */
        final String ACTION_DEPOSIT = "deposit";

        /*
         * Action withdrawal
         */
        final String ACTION_WITHDRAWAL = "withdrawal";

        /*
         * Action exit
         */
        final String ACTION_EXIT = "exit";

        //Eval actions
        boolean action = true;
        switch (pAction) {
            case ACTION_CREATE_CUSTOMER:
                createCustomer(pReader, pBank);
                break;

            case ACTION_CREATE_ACCOUNT:
                createAccount(pReader, pBank);
                break;
                
            case ACTION_DEPOSIT:
                deposit(pReader, pBank);
                break;

            case ACTION_WITHDRAWAL:
                withdrawal(pReader, pBank);
                break;

            case ACTION_EXIT:
                action = false;
                break;

            default:
                System.out.println("Invalid aciton");
                break;
        }
        return action;
    }

    public static Person createCustomer(Scanner pReader, Bank pBank){
        String socialNumber = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        Person addPerson = null;
        System.out.println("Enter the social security number of new customer:");
        socialNumber = pReader.next();
        if (pBank.searchCustomer(socialNumber) != null) {
            System.out.println("Number " + socialNumber +" alredy exists.");
        } else {
            System.out.println("Enter the first name:");
            firstName = pReader.next();
            System.out.println("Enter the middle name:");
            middleName = pReader.next();
            System.out.println("Enter the last name:");
            lastName = pReader.next();
            addPerson = new Person(firstName, middleName, lastName, socialNumber);
            pBank.addCustomer(addPerson);
            System.out.println("Customer created!");
        }

        return addPerson;
    }

    public static CheckingAccount createAccount(Scanner pReader, Bank pBank){
        int number = pBank.getAccounts().size() + 1;
        double ammount = 0;
        Person owner = null;
        String socialNumber = "";
        CheckingAccount addAccount = null;
        System.out.println("Enter the social security number of new account owner:");
        socialNumber = pReader.next();
        owner = pBank.searchCustomer(socialNumber);
        if (owner == null) {
            System.out.println("Customer with social security number " + socialNumber +" does not exist.");
            System.out.println("Do you want to create it? (yes/no)");
            if(pReader.next() == "yes")
                owner = createCustomer(pReader, pBank);
            if(owner == null){
                return addAccount;
            }else{
                System.out.println("Resuming account opening...");
            }
        }
        System.out.println("Enter initial ammount:");
        ammount = tryParseDouble(pReader.next());
        if (ammount == 0){
            System.out.println("Invalid Ammount");
            return addAccount;
        }else if(ammount < Bank.MINIMUM_INITIAL_DEPOSIT){
            System.out.println("Minimum initial deposit is: " + Bank.MINIMUM_INITIAL_DEPOSIT);
            return addAccount;
        }
        addAccount = new CheckingAccount("" + number, ammount, owner);
        pBank.addAccount(addAccount);
        System.out.println("New account number is: " + number);

        return addAccount;
    }

    public static double deposit(Scanner pReader, Bank pBank)
    {
        double ammount = -1;
        String number = "";
        CheckingAccount account;
        System.out.println("Enter account number:");
        number = pReader.next();
        account = pBank.searchAccount(number);
        if(account != null){
            System.out.println("Enter ammount to deposit:");
            ammount = tryParseDouble(pReader.next());
            if(ammount==0){
                System.out.println("Invalid Ammount");
                return -1;
            }
            ammount = account.deposit(ammount);
        } else {
            System.out.println("Account with number " + number +" does not exist.");
            return ammount;
        }

        System.out.println("Your currect balance is: " + ammount);
        return ammount;
    }

    public static double withdrawal(Scanner pReader, Bank pBank)
    {
        double ammount = -1;
        String number = "";
        CheckingAccount account;
        System.out.println("Enter account number:");
        number = pReader.next();
        account = pBank.searchAccount(number);
        if(account != null){
            System.out.println("Enter ammount to withdraw:");
            ammount = tryParseDouble(pReader.next());
            if(ammount==0){
                System.out.println("Invalid Ammount");
                return -1;
            }
            ammount = account.withdrawal(ammount);
        } else {
            System.out.println("Account with number " + number +" does not exist.");
            return ammount;
        }
        
        if(ammount >= 0){
            System.out.println("Your currect balance is: " + ammount);
        } else {
            System.out.println("Action interrupted. Your balance (" + account.getAmmount() + ") is less than the ammmount you're trying to withdraw.");
        }
        
        return ammount;
    }

    public static double tryParseDouble(String pStr){
        double parsedDouble;
        try {
            parsedDouble = Double.parseDouble(pStr);
            return parsedDouble;
        } catch (Exception e) {
            return 0;
        }
    }

}