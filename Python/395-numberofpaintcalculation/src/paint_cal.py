import math


def paint_calculation():
    length = int(input())
    width = int(input())
    gallon = math.ceil(length * width / 350)
    print(f"You will need to purchase {gallon} gallons of paint")
