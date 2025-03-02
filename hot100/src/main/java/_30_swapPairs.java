import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/3/2
 * @apiNote 24. 两两交换链表中的节点
 */
public class _30_swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode;
        ListNode secondNode;
        ListNode nextNode;
        ListNode p = new ListNode(-1, head);
        ListNode curr = p;
        while (curr.next != null && curr.next.next != null) {
            // 初始化节点
            firstNode = curr.next;
            secondNode = curr.next.next;
            nextNode = curr.next.next.next;
            // 模拟操作
            curr.next = secondNode;
            secondNode.next = firstNode;
            firstNode.next = nextNode;
            // 将当前节点指向下一次翻转的前一个节点
            curr = firstNode;
        }
        return p.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 记录第二个节点
        ListNode secondNode = head.next;
        // 递归翻转第二个节点后面的链表
        ListNode newNode = swapPairs2(secondNode.next);
        // 第二个节点的next指向第一个节点，实现翻转
        secondNode.next = head;
        // 第一个节点的next指向 后面链表翻转后的节点
        head.next = newNode;
        // 此时第二个节点是头节点，返回第二个节点
        return secondNode;
    }
}
