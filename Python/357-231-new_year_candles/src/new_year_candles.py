"""write your code in method solve"""


def solve():
    a, b = map(int, input().split())
    ans = 0
    remain = 0
    while a > 0:
        ans += a
        remain += a
        a = remain // b
        remain %= b

    print(ans)

    return
