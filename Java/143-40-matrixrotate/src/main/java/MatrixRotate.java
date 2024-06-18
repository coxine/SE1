import java.util.Scanner;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int rotateAngle = scanner.nextInt();
        switch (rotateAngle % 360) {
            case 90:
                for (int j = 0; j < n; j++) {
                    for (int i = m - 1; i >= 0; i--) {
                        System.out.printf("%d ", matrix[i][j]);
                    }
                    System.out.print("\n");
                }
                break;
            case 180:
                for (int i = m - 1; i >= 0; i--) {
                    for (int j = n - 1; j >= 0; j--) {
                        System.out.printf("%d ", matrix[i][j]);
                    }
                    System.out.print("\n");
                }
                break;
            case 270:
                for (int j = n - 1; j >= 0; j--) {
                    for (int i = 0; i < m; i++) {
                        System.out.printf("%d ", matrix[i][j]);
                    }
                    System.out.print("\n");
                }
                break;
            case 0:
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.printf("%d ", matrix[i][j]);
                    }
                    System.out.print("\n");
                }
                break;

            default:
                break;
        }
        scanner.close();
    }
}
