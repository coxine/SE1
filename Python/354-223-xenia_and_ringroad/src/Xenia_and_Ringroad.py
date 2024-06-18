"""write your code in method solve"""


def solve():
    houseNum, taskNum = map(int, input().split())
    taskPos = list(map(int, input().split()))
    total = 0
    lastPos = 1
    for i in range(0, taskNum):
        if taskPos[i] >= lastPos:
            total += taskPos[i] - lastPos
        else:
            total += taskPos[i] + houseNum - lastPos
        lastPos = taskPos[i]
    print(total)
