"""write your code in method"""


def is_dangerous():
    players = input()
    for i in range(0, len(players) - 7 + 1):
        if players[i : i + 7].count(players[i]) == 7:
            print("YES")
    print("NO")
