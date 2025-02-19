import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2025/2/19
 * @apiNote 56. 合并区间
 */
public class _014_merge {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {
                // 重复
                int left = res.getLast()[0];
                int right = Math.max(intervals[i][1], res.getLast()[1]);
                res.removeLast();
                res.addLast(new int[] {left, right});
            } else {
                res.addLast(new int[] {intervals[i][0], intervals[i][1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
