/**
 * @version v1.0
 * @author OldGj 2025/2/15
 * @apiNote 76. 最小覆盖子串
 */
public class _012_minWindow {
    /**
     * 封装窗口起始位置和终止位置的静态类
     * 在方法返回值时，可以使用起始位置和终止位置截取字符串进行返回
     */
    static class Result {
        int left;
        int right;

        public Result(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

    public String minWindow(String s, String t) {
        char[] sourceArr = s.toCharArray(); // 原始串
        int[] sourceCount = new int[128];

        char[] targetArr = t.toCharArray(); // 目标串
        int[] targetCount = new int[128];

        for (char c : targetArr) {
            targetCount[c]++; // 目标串中一个字符出现了几次
        }
        int count = 0; // 需要满足多少个条件
        for (int i : targetCount) {
            if (i > 0) { // 将一个字符看做一个条件，目标串中有多少种字符就有多少条件
                count++;
            }
        }

        int counted = 0;// 已经满足的条件
        int left = 0; // 滑动窗口的起始位置 left
        Result res = null;
        for (int right = 0; right < sourceArr.length; right++) { // 滑动窗口的终止位置right
            char rightCh = sourceArr[right];
            // 统计原始串 left~right 范围各种字符的个数
            sourceCount[rightCh]++;
            // 如果原始串中字符出现的次数等于目标串中字符出现的次数
            if (sourceCount[rightCh] == targetCount[rightCh]) {
                counted++; // 每满足一个条件，counted++
            }
            while (left <= right && counted == count) { // 当前窗口满足所有条件后，尝试缩小窗口
                // 找所有满足条件的解中，长度最小的
                if (res == null) {
                    res = new Result(left, right);
                } else {
                    if ((right - left) < (res.right - res.left)) {
                        res = new Result(left, right);
                    }
                }
                // 开始移动left，找长度更小的解
                char leftCh = sourceArr[left];
                sourceCount[leftCh]--;
                // 如果原始串中字符出现的次数小于了目标串中字符出现的此时，将counted--
                if (sourceCount[leftCh] < targetCount[leftCh]) {
                    counted--;
                }
                left++;
            }
        }
        return res == null ? "" : new String(sourceArr, res.left, res.right - res.left + 1);
    }
}
