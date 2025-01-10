import java.util.LinkedList;

/**
 * @version v1.0
 * @author OldGj 2025/1/10
 * @apiNote 42. 接雨水
 */
public class _007_trap {
    // 如果柱子的高度是单调递减的，那么肯定存不下雨水
    // 如果出现了一个比之前柱子高的柱子，才有可能有空间能够存下雨水
    // 使用一个单调 栈存放每个柱子的高度，当新来的柱子更高时，不满足单调栈的规则，需要弹出栈顶那些高度低的柱子的时候 计算雨水容量
    // 此时涉及到三个变量，一个是刚加入的柱子，命名为right，一个是被弹出的柱子，命名为pop，还有一个是被弹出柱子左侧的柱子，命名left
    // 水的容量 = (right的索引-left的索引-1) * min(right.height,left.height) - pop.height
    // 因为对于每个柱子我们都需要用它的索引和高度两个状态，因此我们封装一个Data类来描述柱子
    public int trap(int[] heights) {
        LinkedList<Data> stack = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            Data right = new Data(heights[i], i); // 即将放入单调栈中的柱子
            while (!stack.isEmpty() && stack.peek().height < right.height) { // 查看单调栈顶元素是否小于准备入栈的元素
                Data pop = stack.pop(); // 从栈中pop出的柱子
                Data left = stack.peek(); // 栈中pop出柱子后的栈顶柱子就是原先pop柱子左侧的柱子
                // 如果左侧的柱子不为null
                if (left != null) {
                    // 计算水的容量并累加
                    int width = right.index - left.index - 1;
                    int height = Math.min(right.height, left.height) - pop.height;
                    sum += width * height;
                }
            }
            stack.push(right);
        }
        return sum;
    }

    static class Data {
        private int height; // 柱子高度
        private int index; // 柱子的索引

        public Data(int height, int index) {
            this.height = height;
            this.index = index;
        }

    }
}
