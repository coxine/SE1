"""write your code in method"""


def count_factor_num(max, factor):
    # return the num of factors from 1 to max
    num = 0
    n = max
    while n != 0:
        num += n / factor
        n /= factor
    return int(num)


def count_zeros(n):
    # return the the number of zeros
    return min(count_factor_num(n, 2), count_factor_num(n, 5))
