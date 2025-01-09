import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @author OldGj 2025/1/5
 * @apiNote 1. 两数之和
 */
public class _001_twoSum {
    public int[] twoSum(int[] nums, int target) {
        // 「key:数组元素  value：元素对应数组下标」
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
            if (map.containsKey(target - num)) {
                // 如果map中存了和当前元素配对的元素，直接取下标返回
                return new int[]{i, map.get(target - num)};
            } else {
                // 否则将当前元素放入map
                map.put(num, i);
            }
        }
        return null;
    }
}
