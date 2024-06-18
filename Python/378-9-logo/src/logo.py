def logo_play():
    def Draw(board, state, input):
        direction = input[0]
        step = int(input[1])
        if len(input) < 3:
            char = state.lastChar
        else:
            char = input[2]
            state.lastChar = char

        for i in range(0, step):
            if direction == "L":
                state.curY -= 1
            elif direction == "R":
                state.curY += 1
            elif direction == "U":
                state.curX -= 1
            elif direction == "D":
                state.curX += 1

            if isError(state):
                return
            board[state.curX][state.curY] = char

    def isError(state):
        if state.curX < 0 or state.curX >= 10:
            state.isError = True
            return True

        if state.curY < 0 or state.curY >= 10:
            state.isError = True
            return True
        return False

    # Init
    board = []
    for i in range(0, 10):
        row = []
        for j in range(0, 10):
            row.append(" ")
        board.append(row)

    class State:
        curX = 0
        curY = 0
        lastChar = ""
        isError = False

    state = State()

    moveTime = int(input())
    for i in range(0, moveTime):
        Draw(board, state, input().split())
        if state.isError == True:
            print("Error!")
            return

    for row in board:
        print("".join(row))

    return
