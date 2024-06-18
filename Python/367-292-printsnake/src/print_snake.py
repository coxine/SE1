"""write your code in method print_snake"""


"""write your code in method print_snake"""


def print_snake():
    (r, c) = input().split()
    r = int(r)
    c = int(c)
    for i in range(0, r):
        if i % 2 == 0:
            print("#" * c, end="")
        elif i % 4 == 1:
            print("." * (c - 1) + "#", end="")
        elif i % 4 == 3:
            print("#" + "." * (c - 1), end="")

        if i < r - 1:
            print("\n", end="")

