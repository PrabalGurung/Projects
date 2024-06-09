
/**
 * This class is BankCard, super class of other two sub-class(DebitCard and CreditCard).
 *
 * @author (Prabal Gurung)
 * @version (5.1.0)
 */
public class BankCard
{
    //declaring variables
    private int cardId; 
    private double balanceAmount;
    private String bankAccount;
    private String issuerBank;
    private String clientName;
          
    //no args constructor
    protected BankCard()
    {
        
    }
          
    //this is parameterized contructor with four parameters
    protected BankCard (int cardId, double balanceAmount, String issuerBank, String bankAccount)
    {   
        //initalizing variables
        this.cardId = cardId; 
        this.balanceAmount = balanceAmount;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;
        this.clientName=" ";
    }
         
    //getter
    protected int getCardId()
    {
        return cardId;
    }
        
    //getter
    protected double getBalanceAmount()
    {
        return balanceAmount;
    }
       
    //getter
    protected String getBankAccount()
    {
        return bankAccount;
    }
         
    //getter
    protected String getIssuerBank()
    {
        return issuerBank;
    }
          
    //getter
    protected String getClientName()
    {
        return clientName;
    }
          
    //setter
    protected void setClientName (String newClientName)
    {
        this.clientName = newClientName;
    }
          
    //setter
    protected void setBalance (double newBalanceAmount)
    {
        this.balanceAmount = newBalanceAmount;
    }
          
    //this method function to print
    protected void display()
    {
        //checks whether client has filled name or not
        if(clientName !=  " ") {
            //prints following if "if" statement is true
            System.out.println("The client name is " + clientName);
            System.out.println("The card ID is " + cardId); 
            System.out.println("The balanceAmount is " + balanceAmount);  
            System.out.println("The issuer bank is " + issuerBank); 
            System.out.println("The bank account is " + bankAccount);    
        }
        else{
            // prints suitable message if "if" statement is false
            System.out.println("Client name not assigned! Please enter the name and Try Again.");
        }
    }
}