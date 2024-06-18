"""write your code in method"""


def get_num(n, m):
    # return the number of the last person

    # init
    list_of_people = []
    for i in range(1, n + 1):
        list_of_people.append(i)

    # kill
    curPos = 0
    lastKilled = 0
    while list_of_people:
        curPos = (curPos + m - 1) % len(list_of_people)
        lastKilled = list_of_people[curPos]
        print(lastKilled)
        list_of_people.pop(curPos)
    return lastKilled
