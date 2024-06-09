
/**
 * Credit Card is sub-class of Bank Card and has detail of credit card according to question
 *
 * @author (Prabal Gurung)
 * @version (5.1.0)
 */
public class CreditCard extends BankCard
{
    //declaring varaibles
    private int cvcNumber;
    private int gracePeriod;
    private double creditLimit;
    private double interestRate;
    private boolean isGranted;
    private String expirationDate;
    
    /*
     * this is parameterized constructor with eight parameters
     * this method calls (cardId, balanceAmount ,issuerBank ,bankAccount, client name) from its parent class
     * this method also initializes (cvc number, interest rate, expiration date)
     * this method sets is granted to false
     */    
    protected CreditCard (int cardId , double balanceAmount, String issuerBank, String bankAccount, String clientName, int cvcNumber, double interestRate, String expirationDate)
    {
        super(cardId, balanceAmount, issuerBank, bankAccount);
        super.setClientName(clientName);
        this.cvcNumber = cvcNumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        this.isGranted = false;
    }
        
    //getter
    protected int getCvcNumber()
    {
        return cvcNumber;
    }
    
    //getter
    protected double getCreditLimit()
    {
        return creditLimit;
    }
        
    //getter
    protected double getInterestRate()
    {
        return interestRate;
    }
        
    //getter
    protected String getExpirationDate()
    {
        return expirationDate;
    }
        
    //getter
    protected int getGracePeriod()
    {
        return gracePeriod;
    }
        
    //getter
    protected boolean getIsGranted()
    {
        return isGranted;
    }
        
    //setter
    protected void setCreditLimit(double newCreditLimit, int newGracePeriod)
    {
        //checks if entered credit limit is under maximum
        if (newCreditLimit <= (2.5 * super.getBalanceAmount())) {
            //performs following function if true
            creditLimit = newCreditLimit;
            gracePeriod = newGracePeriod;
            isGranted = true;
        }
        else {
        System.out.println("The credit cannot be issued. Credit Limit should be less than or equal to 2.5 times the amount of balance.");//if false following message is displayed
        }
    }
    
    //voids creditcard
    protected void cancelCreditCard() {
        cvcNumber = 0; //intializes cvcNumber to zero
        creditLimit = 0; // initializes creditLimit to zero
        gracePeriod = 0; // initializes gracePeriod to zero
        isGranted = false; // set isGranted to false
    }
    
    //this method function to print
    public void display() {
        super.display(); //prints display method from super class
        System.out.println("CVC Number: " + cvcNumber); //prints cvcNumber
        System.out.println("Interest Rate: " + interestRate); //prints interest rate
        System.out.println("Expiration Date: " + expirationDate); //prints expiration date
        //checks if isGranted value is true
        if (isGranted == true) {
            //if isGranted is set to true then prints following additionally
            System.out.println("Credit Limit: " + creditLimit);
            System.out.println("Grace Period: " + gracePeriod);
        }
    }
}