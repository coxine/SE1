import math


def solve():
    childNum = input()
    child = list(map(int, input().split()))

    groupNumCount = [0]
    for i in range(1, 5):
        groupNumCount.append(child.count(i))
    if groupNumCount[3] > groupNumCount[1]:
        print(
            int(groupNumCount[4] + groupNumCount[3] + math.ceil(groupNumCount[2] / 2))
        )
    else:
        print(
            int(
                groupNumCount[4]
                + groupNumCount[3]
                + math.ceil((groupNumCount[2] * 2 + groupNumCount[1]) / 4)
            )
        )
    return
