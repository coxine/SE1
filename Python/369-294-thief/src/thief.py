# coding=utf-8
# Write your code in method thief


def thief(nums):
    if not nums:
        return 0

    houseAmount = len(nums)
    money = []
    money.append(0)
    money.append(nums[0])
    for i in range(2, houseAmount + 1):
        money.append(max(money[i - 1], money[i - 2] + nums[i - 1]))
    return money[houseAmount]
