import java.util.Arrays;

/**
 * @version v1.0
 * @author OldGj 2025/2/21
 * @apiNote 41. 缺失的第一个正数
 */
public class _017_firstMissingPositive {
    /**
     *  时间复杂度高
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int[] array = Arrays.stream(nums).distinct().filter(x -> x > 0).sorted().toArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] - 1 != i) {
                return i + 1;
            }
        }
        return array.length + 1;
    }

    /**
     *  时间复杂度，空间复杂度都低
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int i = new _017_firstMissingPositive().firstMissingPositive(new int[] {0, 1, 1, 2, 2});
        System.out.println(i);
    }
}
