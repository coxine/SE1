def is_anagram(str1, str2):
    list1 = list(str1)
    list1.sort()
    list2 = list(str2)
    list2.sort()
    if list1 == list2:
        return True
    return False
