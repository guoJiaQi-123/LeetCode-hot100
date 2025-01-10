import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2025/1/9
 * @apiNote 15. 三数之和
 */
public class _006_threeSum {

    /**
     * 三指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        // 排序后数组的第一个值如果大于0，则三数之和后一定不可能有等于0的情况，直接返回
        if (nums[0] > 0) {
            return res; // TODO error
        }
    /*
        使用i指针固定一个值a,使用left指针固定一个值b，使用right指针固定一个值c
        指针 i 的取值范围 [0,nums.length-3],因为后面最少还需要留两个位置给right和left
     */
        for (int i = 0; i < nums.length - 2; i++) {
            // 对a进行去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // TODO error
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

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums); // 排序
        dfs(3, 0, nums.length - 1, nums, 0, new LinkedList<>(), result);
        return result;
    }

    /**
     *
     * @param n 三数之和 n == 3  四数之和 n == 4
     * @param i 左边界
     * @param j 右边界
     * @param nums 数组
     * @param target 目标值
     * @param stack 栈 回溯用
     * @param result 结果集合 -> 存放最后的结果
     */
    public void dfs(int n, int i, int j, int[] nums, int target,
                    LinkedList<Integer> stack, List<List<Integer>> result) {
        if (n == 2) {
            // 如果n==2,走求解两数之和的逻辑
            towSum(nums, i, j, target, stack, result);
            return;
        }
        for (int k = i; k < j - (n - 2); k++) {
            if (k > i && nums[k] == nums[k - 1]) { // 去重
                continue;
            }
            int num = nums[k];
            stack.push(num); // 固定一个值
            dfs(n - 1, k + 1, j, nums, target - num, stack, result);
            stack.pop();
        }
    }

    /**
     * 两数之和
     * @param nums
     * @param i
     * @param j
     * @param target
     * @param stack
     * @param result
     */
    private void towSum(int[] nums, int i, int j, int target,
                        LinkedList<Integer> stack, List<List<Integer>> result) {

        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                ArrayList<Integer> list = new ArrayList<>(stack);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                while (i < j && nums[i] == nums[i - 1]) { // 去重
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) { // 去重
                    j--;
                }
                i++;
                j--;
            }
        }
    }
}
