/**
 * @version v1.0
 * @author OldGj 2025/3/1
 * @apiNote 48. 旋转图像
 */
public class _20_rotate {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平上下翻转,列不变
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] ints = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        new _20_rotate().rotate(ints);
    }
}
