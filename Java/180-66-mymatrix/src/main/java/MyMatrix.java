import java.util.Scanner;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * 
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;

	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * 
	 * @param a
	 */
	public MyMatrix(int[][] a) {
		this.data = a;
	}

	public int[][] getData() {
		return this.data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * 
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B) {
		int lines = this.data.length;
		int cols = (lines == 0) ? 0 : this.data[0].length;
		int[][] ans = new int[lines][cols];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				this.data[i][j] += B.data[i][j];
			}
		}
		return this;
	}

	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * 
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B) {
		int linesA = this.data.length;
		int colsA = (linesA == 0) ? 0 : this.data[0].length;
		int linesB = B.data.length;
		int colsB = (linesB == 0) ? 0 : B.data[0].length;
		int[][] ans = new int[linesA][colsB];
		for (int i = 0; i < linesA; i++) {
			for (int j = 0; j < colsB; j++) {
				int cell = 0;
				for (int k = 0; k < colsA; k++) {
					cell += this.data[i][k] * B.data[k][j];
				}
				ans[i][j] = cell;
			}
		}
		this.data = ans;
		return this;
	}

	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * 
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b) {
		int lines = this.data.length;
		int cols = (lines == 0) ? 0 : this.data[0].length;

		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				this.data[i][j] *= b;
			}
		}
		return this;
	}

	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * 
	 * @return
	 */
	public MyMatrix transpose() {
		int lines = this.data.length;
		int cols = (lines == 0) ? 0 : this.data[0].length;
		int[][] newMat = new int[cols][lines];
		for (int j = 0; j < lines; j++) {
			for (int i = 0; i < cols; i++) {
				newMat[i][j] = this.data[j][i];
			}
		}
		this.data = newMat;
		return this;
	}

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

	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * 
	 * @return
	 */
	public MyMatrix plusFromConsole() {
		Scanner scanner = new Scanner(System.in);
		int[][] MatB = readMatrix(scanner);
		MyMatrix matrixB = new MyMatrix(MatB);
		this.plus(matrixB);
		scanner.close();
		return this;
	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * 
	 * @return
	 */
	public MyMatrix timesFromConsole() {
		Scanner scanner = new Scanner(System.in);
		int[][] MatB = readMatrix(scanner);
		MyMatrix matrixB = new MyMatrix(MatB);
		this.times(matrixB);
		scanner.close();
		return this;
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
	public void print() {
		final String lineBreak = System.getProperty("line.separator");
		int lines = this.data.length;
		int cols = this.data[0].length;
		System.out.print(lineBreak);
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%d", this.data[i][j]);
				System.out.printf("%s", j == cols - 1 ? lineBreak : ' ');
			}
		}
		System.out.print(lineBreak);
	}
}
