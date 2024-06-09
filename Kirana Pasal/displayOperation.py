# Importing necessary modules

import os
import read
import datetime

# This method is main display from where option display is shown.
def cos_Main():
    os.system("cls")
    print("""
          
    $$$$$$$\                        $$\           $$$$$$$\                             $$$$$$\  $$\                           
    $$  __$$\                       $$ |          $$  __$$\                           $$  __$$\ $$ |                          
    $$ |  $$ | $$$$$$\   $$$$$$$\ $$$$$$\         $$ |  $$ |$$\   $$\ $$\   $$\       $$ /  \__|$$$$$$$\   $$$$$$\   $$$$$$\  
    $$$$$$$\ |$$  __$$\ $$  _____|\_$$  _|        $$$$$$$\ |$$ |  $$ |$$ |  $$ |      \$$$$$$\  $$  __$$\ $$  __$$\ $$  __$$\ 
    $$  __$$\ $$$$$$$$ |\$$$$$$\    $$ |          $$  __$$\ $$ |  $$ |$$ |  $$ |       \____$$\ $$ |  $$ |$$ /  $$ |$$ /  $$ |
    $$ |  $$ |$$   ____| \____$$\   $$ |$$\       $$ |  $$ |$$ |  $$ |$$ |  $$ |      $$\   $$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |
    $$$$$$$  |\$$$$$$$\ $$$$$$$  |  \$$$$  |      $$$$$$$  |\$$$$$$  |\$$$$$$$ |      \$$$$$$  |$$ |  $$ |\$$$$$$  |$$$$$$$  |
    \_______/  \_______|\_______/    \____/       \_______/  \______/  \____$$ |       \______/ \__|  \__| \______/ $$  ____/ 
                                                                    $$\   $$ |                                    $$ |      
                                                                    \$$$$$$  |                                    $$ |      
                                                                     \______/                                     \__|      
                                                                                                                        
                                                                                                                                
    """)

    print("""
                                    ╭───────────────────────────────────────────────╮
                                    │       🛍️ Welcome to Best Buy Shop 🛍️            │
                                    ├───────────────────────────────────────────────┤
                                    │          Select an option to proceed:         │
                                    │                                               │
                                    │ 🔍   Enter 1 to Show the Table.               │
                                    │ 💻   Enter 2 to Sell Laptop.                  │
                                    │ 🛒   Enter 3 to Buy From Vendor.              │
                                    │ 🚪   Enter 4 to Exit the Program.             │
                                    ╰───────────────────────────────────────────────╯
    """)

# This method defines table and shows table when it is called.
def get_stockTable():
    os.system("cls")
    reads = read.get_stockData()
    j = 1
    
    print('┌'+ "─" * (143) +'┐')
    print('│'+'SN'.ljust(6)+'│','Name'.ljust(50), '│'+' Brand'.ljust(15), '│'+' Price'.ljust(15), '│'+' Stock'.ljust(15), '│'+' Processor'.ljust(15), '│'+' Graphics Card'.ljust(15)+'│')
    print('├'+ "─" * (143) +'┤')

    for row in reads:
        print('│', str(j).ljust(4) ,'│', row[0].ljust(50), '│'+row[1].ljust(15), '│'+row[2].ljust(15), '│'+row[3].ljust(15), '│'+row[4].ljust(15), '│'+row[5].ljust(15)+'│')
        j = j + 1

    print('└'+ "─" * (143) +'┘')

# This method defines a choice when people tries to buy
def getListForSell():
    print("""
                                        ╔════════════════════════════════════════════════════╗
                                        ║                  Best Buy Shop                     ║
                                        ║════════════════════════════════════════════════════║
                                        ║         Enter 1-5  To Buy Item From Above List     ║
                                        ╚════════════════════════════════════════════════════╝
    """)
    
# displays exit when called
def exit():
    print("""                                         
                                                        ▀█▀ █░█ ▄▀█ █▄░█ █▄▀   █▄█ █▀█ █░█
                                                        ░█░ █▀█ █▀█ █░▀█ █░█   ░█░ █▄█ █▄█
                                                                    
    """)
    
def warningMainDisplay():
    os.system("cls")
    print("""
                            
                        _____  _                       ______       _             __      __   _ _     _   _____                   _   
                        |  __ \| |                     |  ____|     | |            \ \    / /  | (_)   | | |_   _|                 | |  
                        | |__) | | ___  __ _ ___  ___  | |__   _ __ | |_ ___ _ __   \ \  / /_ _| |_  __| |   | |  _ __  _ __  _   _| |_ 
                        |  ___/| |/ _ \/ _` / __|/ _ \ |  __| | '_ \| __/ _ \ '__|   \ \/ / _` | | |/ _` |   | | | '_ \| '_ \| | | | __|
                        | |    | |  __/ (_| \__ \  __/ | |____| | | | ||  __/ |       \  / (_| | | | (_| |  _| |_| | | | |_) | |_| | |_ 
                        |_|    |_|\___|\__,_|___/\___| |______|_| |_|\__\___|_|        \/ \__,_|_|_|\__,_| |_____|_| |_| .__/ \__,_|\__|
                                                                                                                        | |              
                                                                                                                        |_|              
                                                    
        """)
    input("                                                         Press Enter To Continue!!")
    
# display thank you when called
def thankYou():
    print("""
                                  _______ _                 _     __     __           ______           ____              _             
                                 |__   __| |               | |    \ \   / /          |  ____|         |  _ \            (_)            
                                    | |  | |__   __ _ _ __ | | __  \ \_/ /__  _   _  | |__ ___  _ __  | |_) |_   _ _   _ _ _ __   __ _ 
                                    | |  | '_ \ / _` | '_ \| |/ /   \   / _ \| | | | |  __/ _ \| '__| |  _ <| | | | | | | | '_ \ / _` |
                                    | |  | | | | (_| | | | |   <     | | (_) | |_| | | | | (_) | |    | |_) | |_| | |_| | | | | | (_| |
                                    |_|  |_| |_|\__,_|_| |_|_|\_\    |_|\___/ \__,_| |_|  \___/|_|    |____/ \__,_|\__, |_|_| |_|\__, |
                                                                                                                    __/ |         __/ |
                                                                                                                    |___/         |___/ 
                                        
          """)

# display buy more when called
def buyMore():
    print(f"""
                                    1. Buy More
                                    2. Stop 
""")
    
# display bill when called
def bill(customerName, customerAddress, customerNumber, userDemand, userChoice, stockData, totalAmount):
    # checks if file exist or not
    if(os.path.exists(customerName + "Bill.txt")):
        file = open(customerName + "Bill.txt", "a")
        file.write(f"""
+--------------------------------------------------------------------------------------------------+                       
|        Laptop Name     :   {stockData[int(userChoice)][0]:<20}                                                  |
|        Laptop Brand    :   {stockData[int(userChoice)][1]:<10}                                                            |
|        Price           :   {stockData[int(userChoice)][2]:<10}                                                            |
|        Quantity        :   {userDemand:<10}                                                            |
+--------------------------------------------------------------------------------------------------+                       
|        Total Amount    :   ${totalAmount:<10}                                                           |
                       """)
        file.close
    else:
        file = open(customerName + "Bill.txt", "w")
        file.write(f"""
+--------------------------------------------------------------------------------------------------+                       
|                                  Best Buy Shop                                                   |
|                        1234 Main Street, Anytown USA 12345                                       |
|                 Phone: 555-555-5555 Email: info@bestbuyshop.com                                  |
+--------------------------------------------------------------------------------------------------+                       
    |                                                            Date    :{datetime.datetime.now()}                          |
|        Customer Name   :   {customerName:<10}                                                            |
|        Customer Address:   {customerAddress:<10}                                                            |
|        Customer Contact:   {customerNumber:<10}                                                            |
+--------------------------------------------------------------------------------------------------+                                                             
|        Laptop Name     :   {stockData[int(userChoice)][0]:<20}                                                  |
|        Laptop Brand    :   {stockData[int(userChoice)][1]:10}                                                            |
|        Price           :   {stockData[int(userChoice)][2]:<10}                                                            |
|        Quantity        :   {userDemand:<10}                                                            |
+--------------------------------------------------------------------------------------------------+                       
|        Total Amount    :   ${totalAmount:<10}                                                           |
                       """)
        file.close
    
# add grand when called        
def addGrandTotal(customerName, grandTotal): 
    file = open(customerName + "Bill.txt" , "a")
    file.write(f"""                    
|                                                            Shipping Cost   :  1200               |
+--------------------------------------------------------------------------------------------------+                       
|        Grand Total     :   {grandTotal + 1200:<10}                                                           |
+--------------------------------------------------------------------------------------------------+                       
        """)
    file.close

#display bill when called  
def vendorBill(vendorName, userChoice, userDemand, totalAmount):
    data = read.get_stockData()
    # checks if file exist or not
    if(os.path.exists(vendorName + "_Bill.txt")):
        data = read.get_stockData()
        file = open(vendorName + "_Bill.txt", "a")
        file.write(f"""
+--------------------------------------------------------------------------------------------------+                       
|        Laptop Name     : {data[int(userChoice)][0]:<20}                                                    |
|        Item Price      : {totalAmount:<10}                                                              |
|        Item Stock      : {str(userDemand):<10}                                                              |
+--------------------------------------------------------------------------------------------------+                       
|        Total           : {totalAmount:<10}                                                              |                      
                       """)
        file.close
    else:
        file = open(vendorName + "_Bill.txt", "w")
        file.write(f"""
+--------------------------------------------------------------------------------------------------+                       
|                                  Best Buy Shop                                                   |
|                        1234 Main Street, Anytown USA 12345                                       |
|                 Phone: 555-555-5555 Email: info@bestbuyshop.com                                  |
+--------------------------------------------------------------------------------------------------+                       
|                                                            Date    : {datetime.datetime.now()}                          |
+--------------------------------------------------------------------------------------------------+                       
|        Company Name    : {vendorName:<10}                                                              |                       
+--------------------------------------------------------------------------------------------------+                                     
|        Laptop Name     : {data[int(userChoice)][0]:<20}                                                    |
|        Item Price      : {totalAmount:<10}                                                              |
|        Item Stock      : {userDemand:<10}                                                              |
+--------------------------------------------------------------------------------------------------+                       
|        Total           : {totalAmount:<10}                                                              |                      
                       """)
        file.close

#add on vendor 
def addVendorTotal(vendorName, vendorTotal):
    
    withoutVAT = vendorTotal - (vendorTotal * (13/100))
    
    file = open(vendorName + "_Bill.txt" , "a")
    file.write(f"""
+--------------------------------------------------------------------------------------------------+                       
|        Grand Total(Without VAT)    :   {withoutVAT:<10}                                                |
|        Grand Total(With VAT)       :   {vendorTotal:<10}                                                |
+--------------------------------------------------------------------------------------------------+                       
        """)
    file.close
        
           