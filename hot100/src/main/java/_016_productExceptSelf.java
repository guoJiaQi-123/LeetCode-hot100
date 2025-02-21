/**
 * @version v1.0
 * @author OldGj 2025/2/21
 * @apiNote 238. 除自身以外数组的乘积
 */
public class _016_productExceptSelf {

    /**
     * O（n）时间复杂度
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        // left数组用于存储当前下标左侧数的积
        int[] left = new int[nums.length];
        // right 数组用于存储当前下标右侧数的积
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }

    /**
     * O（1）时间复杂度
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        // 在left数组中记录每个下标处左侧值的积 nums：[1,2,3,4]  left：[1,1,2,6]
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // 从右往左遍历left数组，并且使用变量right记录当前下标右侧值的积
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // 最终的结构 = 左侧数的积 * 右侧数的积
            left[i] = left[i] * right;
            // 计算下个下标右侧数的积
            right *= nums[i];
        }
        return left;
    }
}
