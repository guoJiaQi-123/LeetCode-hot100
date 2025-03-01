import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/3/1
 * @apiNote 142. 环形链表 II
 */
public class _026_detectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = head; // 快指针
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果是环形链表
            if (slow == fast) {
                // 相交后，慢指针回头节点
                slow = head;
                while (slow != fast) {
                    // 快慢指针都一次走一步
                    slow = slow.next;
                    fast = fast.next;
                }
                // 再次相遇的节点就交点
                return slow;
            }
        }
        // 如果不是环形链表，则返回null
        return null;
    }
}
