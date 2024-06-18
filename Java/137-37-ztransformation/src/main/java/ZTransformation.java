import java.util.Scanner;

public class ZTransformation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int row = in.nextInt();
        in.close();

        if (row == 1) {
            for (int i = 0; i < input.length(); i++) {
                System.out.printf("%c", input.charAt(i));
                if (i != input.length() - 1) {
                    System.out.print(' ');
                }
            }
        } else {
            char[][] draw = new char[row][input.length() * 2 + 5];
            int[] maxCol = new int[row];
            int curRow = 0;
            int curCol = 0;
            boolean isDown = true;
            for (int i = 0; i < input.length(); i++) {
                draw[curRow][curCol] = input.charAt(i);
                maxCol[curRow] = curCol + 1;
                if (isDown) {
                    if (curRow < row - 1) {
                        curRow++;
                    } else {
                        curRow--;
                        isDown = false;
                        curCol += 2;
                    }
                } else {
                    if (curRow > 0) {
                        curRow--;
                        curCol += 2;
                    } else {
                        curRow++;
                        isDown = true;
                    }
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < maxCol[i]; j++) {
                    System.out.printf("%c", (draw[i][j] == 0) ? ' ' : draw[i][j]);
                }
                if (maxCol[i] > 0) {
                    System.out.print("\n");
                }
            }
        }
    }
}
