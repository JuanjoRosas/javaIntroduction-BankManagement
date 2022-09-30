package environment;

public class CheckingAccount {//Represents an account oppened in Bank.
    //ATRIBUTES---------------------------------------------
    /*
     * Number that identifies the account.
     */
    private String number;

    /*
     * Amount of money in the account.
     */
    private double ammount;

    /*
     * Owner of account.
     */
    private Person owner;

    //CONSTRUCTOR---------------------------------------------
    /*
     * Initializes the values ​​of the Class' attributes.
     */
    public CheckingAccount(String pNumber, double pAmmount, Person pOwner){
        number = pNumber;
        ammount = pAmmount;
        owner = pOwner;
    }

    //METHODS--------------------------------------------------
    //Setters
    public void setNumber(String number) {
        this.number = number;
    }
    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    //Getters
    public String getNumber() {
        return number;
    }
    public double getAmmount() {
        return ammount;
    }
    public Person getOwner() {
        return owner;
    }

    //Other Methods
    /*
     * Increments value of ammount by pAmmount
     */
    public void deposit(double pAmmount){
        ammount += pAmmount;
    }

    /*
     * Decreases value of ammount by pAmmount. 
     * If ammount to substract is greater than current ammount returns -1 else returns ammount after subtraction. 
     */
    public double withdrawal(double pAmmount){
        double valueReturn = -1;
        if(pAmmount <= ammount){
            ammount -= pAmmount;
            valueReturn = ammount;
        }
        return valueReturn;
    }
}
