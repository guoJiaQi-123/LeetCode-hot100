import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2025/1/21
 * @apiNote 560. 和为 K 的子数组
 */
public class _010_subarraySum {

    /**
     * O（n2）时间复杂度高
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int preSum = 0; // 计算前缀和
        // 存放出现过的前缀和「key:前缀和，value:这个前缀和出现过多少次」
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化map，前缀和为，出现过一次
        map.put(0, 1);
        for (int num : nums) {
            preSum += num; // 累加前缀和
            if (map.containsKey(preSum - k)) {
                // 如果出现过preSum-k的前缀和，则累加出现的次数
                count += map.get(preSum - k);
            }
            // 将当前前缀和存入map集合，如果原先map集合中存在，则累加value，否则value为1
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
