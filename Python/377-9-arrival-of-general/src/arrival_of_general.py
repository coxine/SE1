# """write your code in method"""


# def calculate():
#     soliderNum = int(input())
#     soliders = []
#     for _ in range(soliderNum):
#         soliders.append(int(input()))
#     # print(soliders)
#     highestPos = soliders.index(max(soliders))
#     soliders.reverse()
#     lowestPos = -soliders.index(min(soliders)) + soliderNum
#     if highestPos < lowestPos:
#         print(highestPos + (soliderNum - lowestPos))
#     else:
#         print(highestPos + (soliderNum - lowestPos) - 1)


def calculate():
    number = int(input())
    temp = input()
    heights = temp.split()
    heights = list(map(int, heights))
    max_index = heights.index(max(heights))
    min_index_reversed = heights[::-1].index(min(heights))
    if max_index > number - 1 - min_index_reversed:
        print(max_index - 1 + min_index_reversed)
    else:
        print(max_index + min_index_reversed)


# if __name__ == "__main__":
#     calculate()
