import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/2/26
 * @apiNote 206. 反转链表
 */
public class _023_reverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            // 记录下一个节点
            ListNode nextNode = current.next;
            // 当前节点的next指向前一个节点
            current.next = prev;
            // 前一个节点后移
            prev = current;
            // 当前节点后移
            current = nextNode;
        }
        return prev;
    }

    public ListNode reverseList2(ListNode head) {
        // 参数一：前一个节点 参数二：后一个节点
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode temp = curr.next; // 记录下一个节点
        curr.next = prev; // 反转链表
        return reverse(curr, temp);
    }
}
