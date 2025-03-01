/**
 * @version v1.0
 * @author OldGj 2025/3/1
 * @apiNote 240. 搜索二维矩阵 II
 */
public class _21_searchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        // 从矩阵 matrix 的右上角 (0,n−1) 进行搜索
        int x = 0;
        int y = col - 1;
        while (x < row && y >= 0) {
            // 如果当前值直接等于目标值，返回true
            if (matrix[x][y] == target) {
                return true;
            }
            // 如果当前值大于目标值，为了让当前值减小，往左走y--，否则，为了让目标值增大，往下走x++
            if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] twoDArray = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        new _21_searchMatrix().searchMatrix(twoDArray, 5);
    }
}
