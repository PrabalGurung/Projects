
/**
 * This is sub-class of BankCard; DebitCard
 *
 * @author (Prabal Gurung)
 * @version (5.1.0)
 */
 public class DebitCard extends BankCard
 {
    //declaring variables
    private int pinNumber;
    private int withdrawalAmount;
    private boolean hasWithdrawn;
    private String dateOfWithdrawal;
    
    /*
     * this is parameterized constructor with six parameters
     * this method calls (cardId, balanceAmount , issuerBank , bankAccount) from its parent class
     * this method also initializes pinNumber
     * this method sets has withdrawn to false
     */
    protected DebitCard (int cardId, double balanceAmount , String issuerBank, String bankAccount, String clientName, int pinNumber)
    {
        super(cardId, balanceAmount ,issuerBank ,bankAccount);
        super.setClientName(clientName);
        this.pinNumber = pinNumber;
        this.hasWithdrawn = false;
    }
     
    //getter
    protected int getPinNumber()
    {
        return pinNumber;
    }
        
    //getter
    protected int getWithdrawalAmount()
    {
        return withdrawalAmount;
    }
        
    //getter
    protected String getDateOfWithdrawal()
    {
        return dateOfWithdrawal;
    }
        
    //getter
    protected boolean getHasWithdrawn()
    {
        return hasWithdrawn;
    }
     
    //setter
    protected void setWithdrawalAmount(int withdrawalAmount)
    {
        this.withdrawalAmount = withdrawalAmount;
    }
        
    //this method function to withdraw
    protected void withdraw(int pinNumber, int withdrawalAmount, String dateOfWithdrawal) 
    {
        //checks whether the entered pin is same as initial pin
        if (pinNumber == this.pinNumber)
        {
            //checks if balance amount is higher than withdraw amount 
            if(super.getBalanceAmount() >= withdrawalAmount)
            {
                //performs following task if both statement is true
                hasWithdrawn = true;
                this.dateOfWithdrawal = dateOfWithdrawal;
                setBalance(getBalanceAmount() - withdrawalAmount);
                this.withdrawalAmount = withdrawalAmount;
                System.out.println("Withdrawal successful. New balance: " + super.getBalanceAmount());
            }else{
                System.out.println("Insufficient fund");//prints suitable message if balance amount is lower than withdrawal amount
            }
        }else{
            System.out.println("Invalid PIN");//prints suitable message if pin doesn't match to initail pin
        }
    }
        
    //this method function to print
    protected void display()
    {
        super.display();//prints attribute from parent class
        //checks whether hasWithdrawn is true or false
        if (hasWithdrawn = true ) {
            //prints the following if the condition is true
            System.out.println("Pin Number : "+ pinNumber);
            System.out.println("Amount of withdrawal : " + withdrawalAmount);
            System.out.println("Date Of Withdrawal: " + dateOfWithdrawal);
        }else{
            System.out.println("Balance Amount: " + super.getBalanceAmount());//prints balance amount from super class if condiotion is false
        }
    }
 }