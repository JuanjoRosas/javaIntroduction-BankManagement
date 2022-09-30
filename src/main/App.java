package main;

import java.util.Scanner;

import environment.Bank;

public class App {
    public static void main(String[] args) throws Exception {
        //Run app
        Bank bank = new Bank();
        Scanner reader = new Scanner(System.in);
        String strAction = "";
        boolean action = true;

        System.out.println("Welcome to bank management system");

        while(true){
            System.out.println("What do you want to do?");
            strAction = reader.next();
            action = doAction(strAction, reader);
            if(action = false)
                break;
        }
        System.out.println("Goode bye!");
        reader.close();
    }

    /*
     * Evaluates which action to do
     */
    public static boolean doAction(String pAction, Scanner pReader){
        /* 
         * Action create customer
         */
        final String ACTION_CREATE_USER = "create customer";

        /*
         * Action create account
         */
        final String ACTION_CREATE_ACCOUNT = "create account";

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
            case ACTION_CREATE_USER:
                createUser(pReader);
                break;

            case ACTION_CREATE_ACCOUNT:
                
                break;
                
            case ACTION_DEPOSIT:
                
                break;

            case ACTION_WITHDRAWAL:
                
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

    public static void createUser(Scanner pReader){
        
    }
}