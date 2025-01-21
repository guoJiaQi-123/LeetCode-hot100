import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @version v1.0
 * @author OldGj 2025/1/20
 * @apiNote 438. 找到字符串中所有字母异位词
 */
public class _009_findAnagrams {

    // 定义一个对象比较是否是字母异位词
    static class Data {
        private final int[] data = new int[26];

        public Data(String c) {
            for (int i = 0; i < c.length(); i++) {
                data[c.charAt(i) - 97]++;
            }
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Data data1 = (Data) object;
            return Objects.deepEquals(data, data1.data);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(data);
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        // 如果s的长度比p的长度还小，直接返回
        if (s.length() < p.length()) return list;
        // 创建字符串p的Data对象
        Data pData = new Data(p);
        // 定义窗口大小
        int begin = 0;
        int end = p.length();
        while (end <= s.length()) {
            // 截取窗口内的字符串
            String substring = s.substring(begin, end);
            Data subData = new Data(substring);
            // 比较窗口内的字符串于字符串p是否是字母异位词
            if (subData.equals(pData)) {
                list.add(begin);
            }
            // 移动窗口
            begin++;
            end++;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> anagrams = new _009_findAnagrams().findAnagrams("abab", "ab");
        System.out.println(anagrams);
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        // 创建字符频率数组
        int[] pFreq = new int[26];  // p字符串的字符频率
        int[] sFreq = new int[26];  // 当前滑动窗口的字符频率
        // 填充 p 字符串的频率
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }
        // 初始化滑动窗口
        for (int i = 0; i < p.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
        }
        // 如果窗口的字符频率与 p 的字符频率相同，记录起始位置
        if (Arrays.equals(pFreq, sFreq)) {
            list.add(0);
        }
        // 滑动窗口
        for (int end = p.length(); end < s.length(); end++) {
            int begin = end - p.length();
            // 新增字符
            sFreq[s.charAt(end) - 'a']++;
            // 移除旧字符
            sFreq[s.charAt(begin) - 'a']--;
            // 比较窗口和 p 的字符频率
            if (Arrays.equals(pFreq, sFreq)) {
                list.add(begin + 1); // 新的窗口的begin需要+1
            }
        }
        return list;
    }
}
