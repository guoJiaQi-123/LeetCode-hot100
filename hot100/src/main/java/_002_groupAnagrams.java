import java.util.*;

/**
 * @version v1.0
 * @author OldGj 2025/1/5
 * @apiNote 49. 字母异位词分组
 */
public class _002_groupAnagrams {
    /**
     * 通过一个数组判定字母异位词
     */
    static class ArrayKey {
        int[] array = new int[26];

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            ArrayKey arrayKey = (ArrayKey) object;
            return Objects.deepEquals(array, arrayKey.array);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(array);
        }

        public ArrayKey(String str) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                array[c - 97]++;
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayKey, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 字母异位词的ArrayKey一定相同
            ArrayKey key = new ArrayKey(str);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    /**
     * 所有的字母异位词排序后都一样
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        // 「key:排序后的字母异位词，value:所有的字母异位词」
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 转字符数组
            char[] charArray = str.toCharArray();
            // 排序
            Arrays.sort(charArray);
            // 转字符串
            String string = Arrays.toString(charArray);
            // 存在则返回链表，不存在则创建新的链表
            List<String> list = map.computeIfAbsent(string, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
