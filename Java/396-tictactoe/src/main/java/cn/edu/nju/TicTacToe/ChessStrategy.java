package cn.edu.nju.TicTacToe;

public class ChessStrategy {
    private int strategy;
    private Board board;

    public ChessStrategy(String mode, Board board) {
        this.board = board;
        this.strategy = mode.charAt(0) - '0';
    }

    public boolean isFiveInARowMode() {
        return this.strategy == 1;
    }

    /**
     * 移除最早的棋子
     * 
     * @param chessPos 棋子位置
     */
    public void RemoveEarliestChess(String chessPos) {
        if (board.moveQueue.size() == 10) {
            int[] pos = board.moveQueue.poll();
            board.cells[pos[0]][pos[1]] = '_';
        }
        int i = chessPos.charAt(1) - '1';
        int j = chessPos.charAt(0) - 'A';
        board.moveQueue.offer(new int[] { i, j });
    }

    /**
     * 落子
     * 
     * @param cells         棋盘
     * @param currentPlayer 当前玩家
     * @param chessPos      落子位置
     * @return 落子之后的结果
     */
    public Result putChess(char[][] cells, Player currentPlayer, String chessPos) {
        int i = chessPos.charAt(1) - '1';
        int j = chessPos.charAt(0) - 'A';
        if (cells[i][j] != '_') {
            return Result.ERROR;
        }
        cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
        return board.winStrategy.check(cells);
    }

}
