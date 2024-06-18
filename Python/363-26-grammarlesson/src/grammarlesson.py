def isPetyaLanguage():
    wordList = list(input().split())
    wordListConv = []
    for word in wordList:
        wordListConv.append(wordType(word))
    if not isGenderConsistent(wordListConv):
        print("NO")
    elif (
        (not wordListConv.count(3) == 1) and (not wordListConv.count(4) == 1)
    ) and len(wordListConv) > 1:
        print("NO")
    elif wordListConv != sorted(wordListConv):
        print("NO")
    else:
        print("YES")
    return


def wordType(word):
    if word[-4:] == "lios":
        return 1
    elif word[-5:] == "liala":
        return 2
    elif word[-3:] == "etr":
        return 3
    elif word[-4:] == "etra":
        return 4
    elif word[-6:] == "initis":
        return 5
    elif word[-6:] == "inites":
        return 6
    else:
        return 0


def isGenderConsistent(wordListConv):
    for i in range(0, len(wordListConv) - 1):
        if (wordListConv[i + 1] - wordListConv[i]) % 2 == 1:
            return False
    return True
