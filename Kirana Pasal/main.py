# Importing necessary modules

import displayOperation
import operation

# loop until break
while True:
    # call main
    displayOperation.cos_Main()  
    # ask input
    userInput = input("Choose from (1-4): ")

    # check if input is right
    if(userInput == "1"):
        # display table
        displayOperation.get_stockTable()
        input("Press Enter To Continue!!")
    elif(userInput == "2"):
        # call sell
        operation.sellProcess()
    elif(userInput == "3"):
        # call buy
        operation.buyFromVendor()
    elif(userInput == "4"):
        # exit
        displayOperation.exit() 
        break
    else:
        # display warning
        displayOperation.warningMainDisplay()


