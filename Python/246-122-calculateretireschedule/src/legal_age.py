"""write your code in method legal_driving_age"""


def legal_driving_age():
    age = int(input("111"))
    if age < 0:
        print("Please enter a natural number.")
    elif age < 18:
        print("You are not old enough to legally drive.")
    else:
        print("You are old enough to legally drive.")
