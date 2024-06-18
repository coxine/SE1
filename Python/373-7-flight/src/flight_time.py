import datetime
import time


def calcTime(line):
    atd = datetime.datetime.strptime(line[0:8], "%H:%M:%S")
    ata = datetime.datetime.strptime(line[9:17], "%H:%M:%S")
    flightTime = ata - atd
    seconds = flightTime.seconds + 24 * 60 * 60 * flightTime.days
    if len(line) > 18:
        seconds += int(line[20]) * 24 * 60 * 60
    return seconds


def flight_calculation():
    line1 = input()
    line2 = input()
    # enter your code here
    time1 = calcTime(line1)
    time2 = calcTime(line2)
    actualTime = (time1 + time2) / 2
    print(time.strftime("%H:%M:%S", time.gmtime(actualTime)))
