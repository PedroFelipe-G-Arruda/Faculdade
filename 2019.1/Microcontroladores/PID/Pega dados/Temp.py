from datetime import datetime
import serial
import time
import csv

arduino = serial.Serial('COM5', 9600, timeout=.1)
liga = "1"
desliga = "0"
now = datetime.now()
temp = arduino.readline()[:-2].decode("utf-8")

with open('Dados_Temp4.csv', 'w', newline='') as csvfile:
    csvwriter = csv.writer(csvfile,delimiter=';',quotechar='"',quoting=csv.QUOTE_MINIMAL)
    csvwriter.writerow(['Hora'] + ['Temp'])

    while (temp < '80.0'):
        arduino.write(liga.encode())
        time.sleep(1)
        #csvwriter.writerow([time.strftime("%a, %d %b %Y %H:%M:%S", time.localtime())])
        temp = arduino.readline()[:-2].decode("utf-8")
        if temp:
            print(temp)
            csvwriter.writerow([time.strftime("%H:%M:%S", time.localtime())] + [temp])

arduino.write(desliga.encode())

arduino.close()