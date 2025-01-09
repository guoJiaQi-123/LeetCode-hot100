import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2025/1/9
 * @apiNote 15. 三数之和
 */
public class _006_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        // 排序后数组的第一个值如果大于0，则三数之和后一定不可能有等于0的情况，直接返回「校验一些特殊情况」
        if (nums[0] > 0) {
            return res;
        }
    /*
        使用i指针固定一个值a,使用left指针固定一个值b，使用right指针固定一个值c
        指针 i 的取值范围 [0,nums.length-3],因为后面最少还需要留两个位置给right和left
     */
        for (int i = 0; i < nums.length - 2; i++) {
            // 对a进行去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = nums.length - 1;
            int left = i + 1;
            while (left < right) {
                // 三数之和
                int sum = nums[i] + nums[left] + nums[right];
                // 如果三数之和大于0，则需要将right--，反之将left++
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else { // 找到第一个三数和为0，加入结果集合后对数字b和c进行去重
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    // 找到答案时，双指针同时收缩
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
