import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2025/1/22
 * @apiNote 239. 滑动窗口最大值
 */
public class _011_maxSlidingWindow {

    /**
     * 单调递减队列
     */
    static class MonotonicStack {
        private final LinkedList<Integer> deque = new LinkedList<>();

        /**
         * 获取队列头元素
         * @return
         */
        public Integer peek() {
            return deque.peekFirst();
        }

        /**
         * 获取并移除队列头元素
         * @return
         */
        public Integer poll() {
            return deque.pollFirst();
        }

        /**
         * 向单调队列中添加元素
         * @param num
         */
        public void offer(Integer num) {
            // 如果队列尾部元素小于待添加元素，则出队
            while (!deque.isEmpty() && deque.peekLast() < num) {
                deque.pollLast();
            }
            deque.offerLast(num);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列
        MonotonicStack queue = new MonotonicStack();
        // 收集结果集合
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 当前值加入到单调队列
            queue.offer(num);
            // 如果单调队列的最大值「头节点」被移出滑动窗口，则移出头元素
            // nums[i-k]为被移出滑动窗口的元素，也就是滑动窗口最前面的元素
            if (i >= k && nums[i - k] == queue.peek()) {
                queue.poll();
            }
            // 收集当前滑动窗口内的最大值
            // 当k为3时，当i等于2「即k-1」时滑动窗口的大小就是「0,1,2」，此时开始收集最大值
            if (i >= k - 1) {
                list.add(queue.peek());
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static class Solution {
        static class MyQueue {
            Deque<Integer> deque = new LinkedList<>();

            //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
            void poll(int val) {
                if (!deque.isEmpty() && val == deque.peek()) {
                    deque.poll();
                }
            }

            // 添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出，保证队列元素单调递减
            // 比如此时队列元素3,1，此时2将要入队，比1大，所以1弹出，此时队列：3,2
            void add(int val) {
                while (!deque.isEmpty() && val > deque.getLast()) {
                    deque.removeLast();
                }
                deque.add(val);
            }

            //队列队顶元素始终为最大值
            int peek() {
                return deque.peek();
            }
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 1) {
                return nums;
            }
            //存放结果元素的数组
            int[] res = new int[nums.length - k + 1];
            int resIdx = 0;
            //自定义队列
            MyQueue myQueue = new MyQueue();
            //先将前k的元素放入队列
            for (int i = 0; i < k; i++) {
                myQueue.add(nums[i]);
            }
            res[resIdx++] = myQueue.peek();
            for (int i = k; i < nums.length; i++) {
                //滑动窗口移除最前面的元素
                myQueue.poll(nums[i - k]);
                //滑动窗口加入最后面的元素
                myQueue.add(nums[i]);
                //记录对应的最大值
                res[resIdx++] = myQueue.peek();
            }
            return res;
        }
    }
}
