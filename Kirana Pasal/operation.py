# Importing necessary modules
import os
import displayOperation
import read
import write

# instance variable
grandTotal = 0
vendorTotal = 0

def buyFromVendor():
    os.system("cls")
    print("Leave name empty to go to Main Screen")
    print("")
    print("")
    # try input if error throws exception
    try:
        vendorName = input("Enter Company Name: ")
    except:
        displayOperation.warningMainDisplay()
    
    # if condition true proceed else proceed second or third
    if (len(vendorName) > 0):
        # call proceedbuy
        proceedBuy(vendorName)
    elif (len(vendorName) == 0):
        #exit if null
        displayOperation.exit()
        input()
    else:
        # loop if error
        displayOperation.warningMainDisplay()

def proceedBuy(vendorName):   
    while True:    
        # display all
        displayOperation.get_stockTable()
        displayOperation.getListForSell()
        stockData = read.get_stockData()
        
        # try all choice and demand
        try:
            userChoice = int(input("Enter Your Choice: "))
            userDemand = int(input("Enter Number Of Laptop: "))
                
            userChoice = userChoice - 1
            
            # if condition true proceed
            if(userChoice >= 0 and userDemand > 0 and userChoice < 5):
                # calculate
                price = stockData[int(userChoice)][2].replace("$","")
                totalAmount = int(price) * int(userDemand)
                global vendorTotal
                vendorTotal += totalAmount

                # refill stock
                write.refillStock(userDemand, userChoice)
                # make bill
                displayOperation.vendorBill(vendorName, userChoice, userDemand, totalAmount)
                # buy again
                buyAgainVendor(vendorName)  
                break
            else:
                # show error message
                input("Please Enter Valid Choice")
        except:
            # show error message
            displayOperation.warningMainDisplay()
                       
def buyAgainVendor(vendorName):
    # display
    displayOperation.buyMore()
    # try if error throw exception
    try:
        userSelection = input("Choose 1 or 2: ")
    except:
        displayOperation.warningMainDisplay()
    # if condition true proceed
    if (userSelection == "1"):
        proceedBuy(vendorName)
    # if first condition false make final bill and read and break program
    elif(userSelection == "2"):
        os.system("cls")
        displayOperation.addVendorTotal(vendorName, vendorTotal)
        read.displayBill(vendorName)
        input("Press Enter To Continue")
    else:
        displayOperation.warningMainDisplay()
        input("Press any key to Continue")
        buyAgainVendor(vendorName)
        
def sellProcess():
    os.system("cls")
    print("Leave a field empty to go to Main Screen")
    print("")
    print("")
    # try input if error throws exception
    try:
        customerName = input("Enter Customer Name: ")
        customerAddress = input("Enter Customer Address: ")
        customerNumber = input("Enter Customer Number: ")
    except:
        displayOperation.exit()
    # if condition true proceed to next method
    if(len(customerName) > 0 and len(customerAddress) > 0 and len(customerNumber) == 10):
        startSell( customerName, customerAddress, customerNumber)
    elif(len(customerName) == 0 or len(customerAddress) == 0 or len(customerNumber) == 0):
        displayOperation.exit()
        input()
    else:
        displayOperation.warningMainDisplay()
            
def startSell(customerName, customerAddress, customerNumber):
    while True:
        # display
        displayOperation.get_stockTable()
        displayOperation.getListForSell()
        stockData = read.get_stockData()
        # try input if error throw exception
        try:    
            userChoice = input("Enter Your Choice: ")
            userDemand = input("Enter Number Of Laptop: ")
            
            userChoice = str(int(userChoice) - 1)
            
            # if both condition true proceed
            if(int(stockData[int(userChoice)][3])) - int(userDemand) >= 0:
                if((int(stockData[int(userChoice)][3])) >= 0 and int(userChoice) >= 0, int(userDemand) > 0):
                    # calculate
                    price = stockData[int(userChoice)][2].replace("$","")
                    totalAmount = int(price) * int(userDemand)
                    global grandTotal
                    grandTotal += totalAmount
                    
                    # make bill, change stock and proceed to ask buy again
                    displayOperation.bill(customerName, customerAddress, customerNumber, userDemand, userChoice, stockData, totalAmount)
                    write.changeStock(userDemand, userChoice)
                    buyAgain(customerName, customerAddress, customerNumber)
                    break
                else:
                    # display error of condition doesnt match
                    displayOperation.warningMainDisplay()
            else:
                # say out of stock if first condition false
                os.system("cls")
                print("Out Of Stock!! Please Lower Your Demand.")
                input("")
        except:
            # display warning in case of exception
            displayOperation.warningMainDisplay()
        
def buyAgain(customerName, customerAddress, customerNumber):
    displayOperation.buyMore()
    # ask for input if error throw exception
    try:
        userSelection = input("Choose 1 or 2: ")
    except:
        displayOperation.warningMainDisplay()
    # if user selection is one repeat process
    if(userSelection == "1"):
        startSell(customerName, customerAddress, customerNumber)
    # else add grand in bill and read bill
    elif(userSelection == "2"):
        os.system("cls")
        displayOperation.addGrandTotal(customerName, grandTotal)
        read.readData(customerName)
        input()
        displayOperation.thankYou()
        input("Press Enter To Continue")
    else:
        # error display
        displayOperation.warningMainDisplay()
        input("Press any key to Continue")
        buyAgain(customerName, customerAddress, customerNumber)

grandTotal = 0 
vendorTotal = 0

