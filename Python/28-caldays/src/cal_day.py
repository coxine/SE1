"""write your code in method"""


def get_day(month, day):
    date = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    startMonth = 3
    startDate = 4
    days = 0
    for i in range(startMonth, month):
        days += date[i]
    days += day - startDate
    return days
