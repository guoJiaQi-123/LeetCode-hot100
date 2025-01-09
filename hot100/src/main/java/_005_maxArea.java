/**
 * @version v1.0
 * @author OldGj 2025/1/9
 * @apiNote 11. 盛最多水的容器
 */
public class _005_maxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                int area = (j - i) * height[i];
                max = Math.max(area, max);
                i++;
            } else {
                int area = (j - i) * height[j];
                max = Math.max(area, max);
                j--;
            }
        }
        return max;
    }
}
