def special_typing():
    q = int(input())
    for _ in range(0, q):
        s = list(input())
        t = list(input())

        if len(s) < len(t):
            print("NO")
            continue

        s.reverse()
        t.reverse()

        sptr = 0
        tptr = 0

        while sptr < len(s) and tptr < len(t):
            if s[sptr] == t[tptr]:
                sptr += 1
                tptr += 1
            else:
                sptr += 2

        if tptr == len(t):
            print("YES")
        elif sptr >= len(s):
            print("NO")


if __name__ == "__main__":
    special_typing()
