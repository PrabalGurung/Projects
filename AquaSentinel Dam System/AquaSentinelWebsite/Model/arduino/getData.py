import serial
import time
from datetime import datetime

# Establish serial connection with Arduino
ser = serial.Serial('COM5', 9600)  # Adjust 'COM3' to match your Arduino's port

# Specify the full path to the file
file_path = r"D:\Informatics\IDE\XAMPP\htdocs\AquaSentinel\Data\arduinoData.csv"

# Open the text file for writing
with open(file_path, "a") as file:
    line_counter = 0
    # Continuously read from serial and write to file
    while True:
        line = ser.readline().decode().strip()  # Read a line from serial
        if line:  # If line is not empty
            print(line)  # Print to console
            file.write(line)  # Write to file
            file.flush()  # Flush buffer
            line_counter += 1
            if line_counter == 3:
                # Add current time and date
                file.write(", " + datetime.now().strftime("%Y-%m-%d %H:%M:%S") + "\n")
                line_counter = 0  # Reset the counter
            else:
                file.write(",")  # Write comma if it's not the end of the line
        time.sleep(1)  # Adjust as needed for reading rate
