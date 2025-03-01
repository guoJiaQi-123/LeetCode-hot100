/**
 * @version v1.0
 * @author OldGj 2025/3/1
 * @apiNote 73. 矩阵置零
 */
public class _018_setZeroes {
    public void setZeroes(int[][] matrix) {
        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;
        // 标记位，标记初始矩阵的第一列是否有0
        boolean flagCol0 = false;
        // 标记位，标记初始矩阵的第一行是否有0
        boolean flagRow0 = false;
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                // 标记初始矩阵的第一列是否有0
                flagCol0 = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                // 标记初始矩阵的第一行是否有0
                flagRow0 = true;
                break;
            }
        }
        // 如果非第一行第一列的零，则将对应的行列第一位置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 如果对应行或者列的第一位为0，则将这一行这一列所以的值都置0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 如果第一列原先就有0，则将第一列全部置0
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        // 如果第一行原先就有0，则将第一行全部置0
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
