import math


def pizza_calculation():
    peopleNum = int(input("111"))
    pizzaNum = int(input("111"))
    pizzaPiece = int(input("111"))
    pizza = pizzaNum * pizzaPiece / peopleNum
    leftover = (pizzaNum * pizzaPiece) % peopleNum
    print(f"Each people gets {int(pizza)} pieces of pizza\n{leftover} leftover pieces")
