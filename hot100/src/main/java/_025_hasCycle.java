import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/2/26
 * @apiNote 141. 环形链表
 */
public class _025_hasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // 慢指针
        ListNode fast = head; // 快指针
        while (fast != null && fast.next != null) {
            // 慢指针一次走一步，快指针一次走两步
            slow = slow.next;
            fast = fast.next.next;
            // 如果是环形链表，快慢指针会相遇
            if (slow == fast) {
                return true;
            }
        }
        // 否则不是环形链表
        return false;
    }
}
