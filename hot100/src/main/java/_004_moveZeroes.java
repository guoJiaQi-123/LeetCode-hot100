/**
 * @version v1.0
 * @author OldGj 2025/1/6
 * @apiNote 283. 移动零
 */
public class _004_moveZeroes {
    public void moveZeroes(int[] nums) {
        // 慢指针构建数组，快指针扫描非零数
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        // 快指针遍历完后，将慢指针后的所有元素都置为零
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
