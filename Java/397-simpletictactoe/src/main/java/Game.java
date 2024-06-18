public class Game {
  int curPlayer; // Current player (1 for X, 2 for O)
  char[][] board; // Game board

  // Constructor initializes the game
  public Game() {
    this.curPlayer = 1; // X starts the game
    this.board = new char[3][3]; // 3x3 game board
  }

  // Check if the game is still ongoing
  private boolean isGaming() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (this.board[i][j] == '\0') { // Empty cells are initialized to '\0'
          return true;
        }
      }
    }
    return false;
  }

  // Determine the winner of the game
  private Result winPerson() {
    // Check rows and columns for a win
    for (int i = 0; i < 3; i++) {
      if ((this.board[i][0] != '\0' && this.board[i][0] == this.board[i][1] && this.board[i][1] == this.board[i][2]) ||
          (this.board[0][i] != '\0' && this.board[0][i] == this.board[1][i] && this.board[1][i] == this.board[2][i])) {
        return this.board[i][0] == 'X' ? Result.X_WIN : Result.O_WIN;
      }
    }

    // Check diagonals for a win
    if ((this.board[0][0] != '\0' && this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) ||
        (this.board[0][2] != '\0' && this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0])) {
      return this.board[1][1] == 'X' ? Result.X_WIN : Result.O_WIN;
    }

    // Check for ongoing game or draw
    return this.isGaming() ? Result.GAMING : Result.DRAW;
  }

  // Print the current state of the board
  private void printBoard() {
    String lineSeparator = System.getProperty("line.separator");
    System.out.print("  A B C" + lineSeparator);
    for (int i = 0; i < 3; i++) {
      System.out.printf("%d ", i + 1);
      for (int j = 0; j < 3; j++) {
        System.out.printf("%c%s", this.board[i][j] != '\0' ? this.board[i][j] : '_', j == 2 ? lineSeparator : " ");
      }
    }
  }

  // Execute a move on the board
  private void move(String step) {
    int row = step.charAt(1) - '1'; // Convert '1'-'3' to 0-2
    int column = step.charAt(0) - 'A'; // Convert 'A'-'C' to 0-2
    this.board[row][column] = (this.curPlayer == 1) ? 'X' : 'O';
    this.curPlayer = (this.curPlayer == 1) ? 2 : 1; // Switch player

  }

  // 游戏主方法playGame
  // 输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
  public Result playGame(String s) {
    String[] steps = s.split(",");
    for (String step : steps) {
      this.move(step);
      this.printBoard();
    }
    return this.winPerson();

  }

  public static void main(String[] args) {
    Game game = new Game();
    Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
    System.out.println(result);
  }
}
