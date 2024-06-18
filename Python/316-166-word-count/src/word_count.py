import re


def wordcount(filepath):
    file = open(filepath, "r")
    allWords = []
    while True:
        line = file.readline()
        if len(line) == 0:
            break
        wordsInLine = line.split()
        for word in wordsInLine:
            allWords.append(word)
    allWords.sort()

    wordCount = []
    isVisited = []
    for word in allWords:
        if not word in isVisited:
            wordCount.append([word, allWords.count(word)])
            isVisited.append(word)

    wordCount.sort(key=lambda x: x[1], reverse=True)

    wordLen = -1
    for words in wordCount:
        wordLen = max(len(words[0]), wordLen)

    for words in wordCount:
        print(f"{words[0]}:{' '*(wordLen-len(words[0])+1)}{'*'*words[1]}")


if __name__ == "__main__":
    wordcount("./test/words")
