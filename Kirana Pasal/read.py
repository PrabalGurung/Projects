# set stock data from stock.txt
def get_stockData():
    data = []
    file = open('stock.txt','r')
    lines = file.readlines()
    for i in range (len(lines)):
        data.append(lines[i].strip('\n').split(","))
    file.close
    return data

# read bill and show for buy
def displayBill(vendorName):
    bill = open(vendorName + "_Bill.txt", "r")
    print(bill.read())
    bill.close()

#  read bill and show for sell
def readData(customerName):
    bill = open(customerName + "Bill.txt", "r")
    print(bill.read())
    bill.close
