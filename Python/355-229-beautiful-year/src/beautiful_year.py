"""write your code in method"""


def isBeautifulYear(year):
    digits = []
    while year:
        digits.append(year % 10)
        year //= 10
    for i in digits:
        if digits.count(i) > 1:
            return False
    return True


def get_year():
    year = int(input())
    while True:
        year += 1
        if isBeautifulYear(year):
            print(year)
            break
    return
