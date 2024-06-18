package edu.nju;

import java.util.Scanner;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * 
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * 
	 * @return result matrix = A + B
	 */
	public int[][] readMatrix(Scanner scanner) {
		int lines = scanner.nextInt();
		int cols = scanner.nextInt();
		int[][] ans = new int[lines][cols];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				ans[i][j] = scanner.nextInt();
			}
		}

		return ans;

	}

	public int[][] plus(int[][] A, int[][] B) {
		int lines = A.length;
		int cols = (lines == 0) ? 0 : A[0].length;
		int[][] ans = new int[lines][cols];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				ans[i][j] = A[i][j] + B[i][j];
			}
		}
		return ans;
	}

	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * 
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B) {
		int linesA = A.length;
		int colsA = (linesA == 0) ? 0 : A[0].length;
		int linesB = B.length;
		int colsB = (linesB == 0) ? 0 : B[0].length;
		int[][] ans = new int[linesA][colsB];
		for (int i = 0; i < linesA; i++) {
			for (int j = 0; j < colsB; j++) {
				int cell = 0;
				for (int k = 0; k < colsA; k++) {
					cell += A[i][k] * B[k][j];
				}
				ans[i][j] = cell;
			}
		}
		return ans;
	}

	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int[][] plusFromConsole() {
		Scanner scanner = new Scanner(System.in);
		int[][] A = readMatrix(scanner);
		int[][] B = readMatrix(scanner);
		scanner.close();
		return plus(A, B);
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole() {

		Scanner scanner = new Scanner(System.in);
		int[][] A = readMatrix(scanner);
		int[][] B = readMatrix(scanner);
		scanner.close();
		return times(A, B);
	}

	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 *
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 *
	 */
	public void print(int[][] A) {
		int lines = A.length;
		int cols = A[0].length;
		System.out.print("\n");
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%d", A[i][j]);
				System.out.printf("%c", j == cols - 1 ? '\n' : ' ');
			}

		}
	}
}
