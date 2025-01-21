import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @version v1.0
 * @author OldGj 2025/1/20
 * @apiNote 3. 无重复字符的最长子串
 */
public class _008_lengthOfLongestSubstring {

    /**
     * 使用链表充当子串，如果出现重复字符，则不断删除链表头中的字符，直到不出现重复，时间复杂度高
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 参数校验
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int right = 0; // 滑动窗口的右边界
        int max = 0; // 最长子串
        // 这个list链表就相当于连续子串
        LinkedList<Character> list = new LinkedList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            // 如果连续子串中出现重复的字符，则一直删除子串头的字符，直到不出现重复
            while (list.contains(c)) {
                list.removeFirst();
            }
            // 将当前字符添加到子串中
            list.addLast(c);
            right++;
            // 记录最长子串
            max = Math.max(list.size(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new _008_lengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }

    /**
     * 使用map存储子串，「key：字符，value：字符的索引下标」
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int begin = 0;
            int maxLength = 0;
            for (int end = 0; end < s.length(); end++) {
                char ch = s.charAt(end);
                // 如果发现重复字符，直接跳到重复字符下标的下一个字符位置并且更新字符下标
                if (map.containsKey(ch)) {
                    begin = Math.max(begin, map.get(ch) + 1);
                    map.put(ch, end);
                } else {
                    // 没有出现重复，则记录字符和其下标位置
                    map.put(ch, end);
                }
                maxLength = Math.max(maxLength, end - begin + 1);
            }
            return maxLength;
        }
    }

    /**
     * 题目要求s是ASCII表中的字符
     * 使用数组充当map可以进一步减少时间和内存消耗
     * 使用数组下标充当key存储字符，数组值存放索引下标，如果没有该字符，默认值为-1
     */
    static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            int begin = 0;
            int end = 0;
            int max = 0;
            int[] map = new int[128];
            Arrays.fill(map, -1);
            while (end < s.length()) {
                char ch = s.charAt(end);
                // 如果出现重复，将begin指针直接跳转到重复字符下标「提前存储在了map中」的下一个位置
                if (map[ch] != -1) {
                    begin = Math.max(begin, map[ch] + 1);
                }
                map[ch] = end;
                max = Math.max(max, end - begin + 1);
                end++;
            }
            return max;
        }
    }
}
