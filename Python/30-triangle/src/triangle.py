"""write your code in method"""


def is_triangle(a, b, c):
    if (a + b > c) and (b + c) > a and (c + a) > b:
        return True
    return False
    # 返回True or False
