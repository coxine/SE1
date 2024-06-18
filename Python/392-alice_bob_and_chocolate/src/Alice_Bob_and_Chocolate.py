"""write your code in method solve"""


def solve(n, time_list):
    aliceTime = 0
    bobTime = 0
    aliceNum = 0
    bobNum = 0
    alicePos = 0
    bobPos = 0 + n - 1
    while alicePos <= bobPos:
        if aliceTime < bobTime:
            aliceTime += time_list[alicePos]
            alicePos += 1
            aliceNum += 1
        elif aliceTime > bobTime:
            bobTime += time_list[bobPos]
            bobPos -= 1
            bobNum += 1
        elif aliceTime == bobTime:
            if bobPos - alicePos == 0:
                aliceTime += time_list[alicePos]
                break
            else:
                bobTime += time_list[bobPos]
                bobPos -= 1
                bobNum += 1
                aliceTime += time_list[alicePos]
                alicePos += 1
                aliceNum += 1

    return [aliceNum, n - aliceNum]


if __name__ == "__main__":
    n = int(input())
    time_list = list(map(int, input().split()))
    print(solve(n, time_list))
