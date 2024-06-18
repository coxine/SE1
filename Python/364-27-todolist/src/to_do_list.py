"""write your code in following methods"""

file_path = "./tasks.txt"


def AddItem(command: list, file_path):
    file = open(file_path, "+a")
    for i in command[2:]:
        file.write(f"todo:{i}\n")
    file.close()


def RemoveTaskByLine(fileLine, line):
    return False, fileLine


def MarkTaskAsCompleted(fileLine, line):
    newLine = ["completed:", line[1], "\n"]
    fileLine = "".join(newLine)
    return True, fileLine


def UpdateTaskStatus(command, file_path, validFunc):
    def ModifyTasks(itemName, file_path):
        file = open(file_path, "r")
        fileContent = []
        while True:
            fileLine = file.readline()
            if fileLine == "":
                file.close()
                break
            line = fileLine.split(":")
            line[1] = line[1].split("\n")[0]
            if line[1] == itemName:
                isToAdd, fileLine = validFunc(fileLine, line)
                if isToAdd is True:
                    fileContent.append(fileLine)
                continue
            fileContent.append(fileLine)
        return fileContent

    def SaveTasks(itemName, file_path):
        fileLines = ModifyTasks(itemName, file_path)
        file = open(file_path, "w+")
        for i in range(0, len(fileLines)):
            file.write(fileLines[i])
        file.close()

    for itemName in command[2:]:
        SaveTasks(itemName, file_path)
    return


def DisplayTasksByStatus(status, file_path):
    file = open(file_path, "r")
    while True:
        fileLine = file.readline()
        if fileLine == "":
            file.close()
            break

        line = fileLine.split(":")
        if status == "" or line[0] == status:
            print(f"{line[0]}:{line[1]}", end="")
    return


def ParseInputCommand():
    isInQuote = False
    command = []
    newWord = ""
    inputLine = input()
    for c in inputLine:
        if c == " " and not isInQuote:
            command.append(newWord)
            newWord = ""
        elif c == '"':
            isInQuote = not isInQuote
        else:
            newWord += c
    command.append(newWord)
    newWord = ""
    return command


def to_do():
    while True:
        command = ParseInputCommand()
        if command[1] == "-a":
            AddItem(command, file_path)
        elif command[1] == "-d":
            UpdateTaskStatus(command, file_path, RemoveTaskByLine)
        elif command[1] == "-c":
            UpdateTaskStatus(command, file_path, MarkTaskAsCompleted)
        elif command[1] == "-f":
            DisplayTasksByStatus(command[2], file_path)
        elif command[1] == "-all":
            DisplayTasksByStatus("", file_path)
        else:
            return
