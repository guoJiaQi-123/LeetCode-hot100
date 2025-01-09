import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @version v1.0
 * @author OldGj 2025/1/6
 * @apiNote 128. 最长连续序列
 */
public class _003_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int count = 0;
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                temp += 1;
            } else {
                temp = 0;
            }
            count = Math.max(count, temp);
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int i = new _003_longestConsecutive().longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        System.out.println(i);
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        // 使用set去重
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0; // 最长序列
        for (int num : set) {
            if (!set.contains(num - 1)) { // 如果num-1不在集合中，则以他位序列第一个元素，判断最长序列
                int currentNum = num;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                // 更新最长序列长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }


}
