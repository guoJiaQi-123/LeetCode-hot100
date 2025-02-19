/**
 * @version v1.0
 * @author OldGj 2025/2/19
 * @apiNote 189. 轮转数组
 */
public class _015_rotate {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);  // 反转整个字符串
        reverse(nums, 0, k - 1);  // 反转区间为前 k 的子串
        reverse(nums, k, n - 1);  // 反转区间为k到末尾的子串
    }

    /**
     * 反转nums数组start到end区间的数字
     */
    private void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
    }
}
