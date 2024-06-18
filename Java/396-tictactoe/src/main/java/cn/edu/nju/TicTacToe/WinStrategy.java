package cn.edu.nju.TicTacToe;

public class WinStrategy {
    private int strategy;
    private Board board;

    public WinStrategy(String mode, Board board) {
        this.strategy = mode.charAt(1) - '0';
        this.board = board;
    }

    public boolean isDiagonalMode() {
        return this.strategy == 0;
    }

    /**
     * 检查是否分出胜负
     * 
     * @param cells 棋盘
     * @return 游戏结果
     */
    public Result check(char[][] cells) {
        // horizontal
        for (int i = 0; i < board.boardSize; i++) {
            for (int j = 2; j < board.boardSize; j++) {
                if (cells[i][j] == cells[i][j - 1] && cells[i][j] == cells[i][j - 2] && cells[i][j] != '_') {
                    return cells[i][j] == 'X' ? Result.X_WIN : Result.O_WIN;
                }
            }
        }

        // vertical
        for (int j = 0; j < board.boardSize; j++) {
            for (int i = 2; i < board.boardSize; i++) {
                if (cells[i][j] == cells[i - 1][j] && cells[i][j] == cells[i - 2][j] && cells[i][j] != '_') {
                    return cells[i][j] == 'X' ? Result.X_WIN : Result.O_WIN;
                }
            }
        }

        // diagonal
        if (this.isDiagonalMode()) {
            for (int i = 2; i < board.boardSize; i++) {
                for (int j = 2; j < board.boardSize; j++) {
                    if (cells[i][j] == cells[i - 1][j - 1] && cells[i][j] == cells[i - 2][j - 2]
                            && cells[i][j] != '_') {
                        return cells[i][j] == 'X' ? Result.X_WIN : Result.O_WIN;
                    }
                }
            }
            for (int i = 2; i < board.boardSize; i++) {
                for (int j = 0; j < board.boardSize - 2; j++) {
                    if (cells[i][j] == cells[i - 1][j + 1] && cells[i][j] == cells[i - 2][j + 2]
                            && cells[i][j] != '_') {
                        return cells[i][j] == 'X' ? Result.X_WIN : Result.O_WIN;
                    }
                }
            }
        }

        // 未分出胜负
        for (int i = 0; i < board.boardSize; ++i) {
            for (int j = 0; j < board.boardSize; ++j) {
                if (cells[i][j] == '_')
                    return Result.GAMING;
            }
        }

        return Result.DRAW;
    }

}