# Importing necessary modules
import read

# increase demand accorodingly
def refillStock(userDemand, userChoice):
    stockData = read.get_stockData()
    stockData[int(userChoice)][3] = " " +str(int(stockData[int(userChoice)][3]) + int(userDemand))
    write_stockData_to_file(stockData)
    
# decrease demand accorodingly
def changeStock(userDemand, userChoice):
    stockData = read.get_stockData()
    stockData[int(userChoice)][3] = " " +str(int(stockData[int(userChoice)][3]) - int(userDemand))
    write_stockData_to_file(stockData)

# write changes in stock.txt 
def write_stockData_to_file(stockData):
    stockData_str = ""
    for sublist in stockData:
        line = ""
        for item in sublist:
            line += str(item) + ","
        line = line.rstrip(",") + "\n"
        stockData_str += line
    file = open("stock.txt", "w")
    file.write(stockData_str)  
    file.close


        