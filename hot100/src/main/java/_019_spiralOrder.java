import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2025/3/1
 * @apiNote 54. 螺旋矩阵
 */
public class _019_spiralOrder {
    /*
          1   2   3
          8   9   4
          7   6   5
       */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null) {
            return res;
        }
        int rows = matrix.length; // 行
        int columns = matrix[0].length; // 列
        int left = 0; // 左边界
        int right = columns - 1; // 右边界
        int top = 0; // 上边界
        int bottom = rows - 1; // 下边界
        while (left <= right && top <= bottom) {
            // 循环不变量原则，遵循左闭右闭
            for (int column = left; column <= right; column++) {
                res.add(matrix[top][column]); // 从左到右 1 2 3
            }
            for (int row = top + 1; row <= bottom; row++) {
                res.add(matrix[row][right]); // 从上到下 4 5
            }
            if (left < right && top < bottom) { // 防止只有一行的矩形或者一列的矩形
                for (int column = right - 1; column > left; column--) {
                    res.add(matrix[bottom][column]); // 从右到左 6
                }
                for (int row = bottom; row > top; row--) {
                    res.add(matrix[row][left]); // 从下到上 7 8
                }
            }
            // 模拟一圈，缩小边界
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }

    /**
     * 螺旋矩阵2
     * @param n 正方形边数
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0; // 控制行
        int j = 0; // 控制列
        int count = 1; // 填充的值
        int loop = n / 2; //每个圈循环几次，例如n为奇数3，那么loop = 1 只是循环一圈，矩阵中间的值需要单独处理
        int start = 0; // 每一圈的起始位置
        int offset = 1;// 需要控制每一条边遍历的长度，每次循环右边界收缩一位
        while (loop > 0) { // 一个while循环是模拟填充了一圈
            // 模拟上边从左到右，从start开始，到 n-offset 为止，每填充一个，count++
            for (j = start; j < n - offset; j++) {
                res[start][j] = count++;
            }
            // 模拟右边从上到下，从start行开始，到n-offset行结束
            for (i = start; i < n - offset; i++) {
                res[i][j] = count++;
            }
            // 模拟下边从右到左
            for (; j >= offset; j--) {
                res[i][j] = count++;
            }
            // 模拟右边从下到上
            for (; i >= offset; i--) {
                res[i][j] = count++;
            }
            // 填充一圈完成后
            start++; // 起始位置++ 之前是[0,0]位置，下一圈的起始位置就是[1,1]
            offset++; // 每填充一圈，下一圈的右边界就要收缩一位
            loop--;
        }
        if (n % 2 != 0) { // n 为奇数时，单独处理矩阵中心的值
            res[start][start] = count;
        }
        return res;
    }
}
