
import java.util.Arrays;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法
 * 1.传入一个int[][]进行2个矩阵的操作
 * 2.返回一个int[][]
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * 
 * @author Qin Liu
 *
 */
public class BadMatrix {
	private int[][] data;

	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * 
	 * @param a
	 */
	public BadMatrix(int[][] a) {
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * 
	 * @param b
	 * @return
	 */
	public int[][] plus(int[][] B) {
		int lines = this.data.length;
		int cols = (lines == 0) ? 0 : this.data[0].length;
		int[][] ans = new int[lines][cols];
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				ans[i][j] = this.data[i][j] + B[i][j];
			}
		}
		return ans;

	}

	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * 
	 * @param b
	 * @return
	 */
	public int[][] times(int[][] B) {
		int linesA = this.data.length;
		int colsA = (linesA == 0) ? 0 : this.data[0].length;
		int linesB = B.length;
		int colsB = (linesB == 0) ? 0 : B[0].length;
		int[][] ans = new int[linesA][colsB];
		for (int i = 0; i < linesA; i++) {
			for (int j = 0; j < colsB; j++) {
				int cell = 0;
				for (int k = 0; k < colsA; k++) {
					cell += this.data[i][k] * B[k][j];
				}
				ans[i][j] = cell;
			}
		}
		return ans;
	}

	// 不要修改下面print方法
	/**
	 * 打印出该矩阵的数据
	 * 
	 */
	public void print() {
		System.out.print(this.toString());
	}

	/**
	 * 实现toString方法
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
	public String toString() {
		String lineBreak = System.getProperty("line.separator");
		String ans = new String(lineBreak);
		// int line = this.length;
		int lines = this.data.length;
		int cols = this.data[0].length;
		for (int i = 0; i < lines; i++) {
			for (int j = 0; j < cols; j++) {
				ans += this.data[i][j];
				ans += (j == cols - 1) ? lineBreak : ' ';
			}
		}
		return ans;
	}

	// 不要修改下面equals方法
	public boolean equals(Object o) {
		if (this.toString().equals(((BadMatrix) o).toString()))
			return true;
		else
			return false;
	}
}
