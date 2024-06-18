"""write your code in method"""


def get_string():
    inputString = input()
    newString = []
    for char in inputString:
        if char.isupper():
            char=char.lower()
        if char in ["a", "e", "i", "o", "u"]:
            continue

        newString.append(".")
        newString.append(char)
    printString = "".join(newString)
    print(printString)
    
if __name__=='__main__':
    get_string()
