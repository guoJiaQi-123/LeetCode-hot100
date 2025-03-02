import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/3/2
 * @apiNote 19. 删除链表的倒数第 N 个结点
 */
public class _029_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哨兵节点
        ListNode p = new ListNode(-1, head);
        ListNode slow = p; // 慢指针
        ListNode fast = p; // 快指针
        // 快指针先走n步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 快慢指针一起走，知道快指针走到链表尾部，此时慢指针的next就是要删除的节点
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除节点
        slow.next = slow.next.next;
        // 返回头节点
        return p.next;
    }
}
