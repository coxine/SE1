"""write your code in method"""


def is_prime(n):
    # n>1
    # return True or False
    for i in range(2, int(pow(n, 0.5) + 1)):
        if n % i == 0:
            return False

    return True
