package cn.edu.nju.TicTacToe;

import java.util.LinkedList;
import java.util.Queue;

class Board {
	/*
	 * chessStrategy: 0-正常模式 1-五子模式
	 * winStrategy: 0-横竖斜胜利 1-横竖胜利
	 */
	protected char[][] cells;
	protected int boardSize;
	protected ChessStrategy chessStrategy;
	protected WinStrategy winStrategy;
	protected Queue<int[]> moveQueue = new LinkedList<>();
	protected Player player = Player.X;

	public Board(int boardSize, String gameMode) {
		this.boardSize = boardSize;
		this.cells = new char[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				this.cells[i][j] = '_';
			}
		}
		this.chessStrategy = new ChessStrategy(gameMode, this);
		this.winStrategy = new WinStrategy(gameMode, this);
	}

	/**
	 * @param chessPos 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String chessPos) {
		if (this.chessStrategy.isFiveInARowMode()) {
			this.chessStrategy.RemoveEarliestChess(chessPos);
		}
		return this.chessStrategy.putChess(this.cells, nextPlay(), chessPos);
	}

	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay() {
		Player res = player;
		player = (player == Player.X) ? Player.O : Player.X;
		return res;
	}

	/**
	 * 打印棋盘
	 */
	public void print() {
		System.out.print(" ");
		for (int i = 0; i < boardSize; i++) {
			System.out.print(" " + (char) ('A' + i));
		}
		System.out.println();
		for (int i = 0; i < this.boardSize; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < this.boardSize; j++) {
				System.out.print(" " + cells[i][j]);
			}
			System.out.println();
		}
	}
}