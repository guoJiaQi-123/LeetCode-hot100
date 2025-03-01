import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/2/26
 * @apiNote 234. 回文链表
 */
public class _024_isPalindrome {
    public boolean isPalindrome(ListNode head) {
        // 获取中间节点
        ListNode middle = this.middle(head);
        // 反转中间节点后面的链表
        ListNode newHead = this.reverse(middle);
        // 反转后的链表与原来链表做比较
        return this.compare(newHead, head);
    }

    //反转后的链表与原来链表做比较
    private boolean compare(ListNode newHead, ListNode head) {
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    //反转链表
    private ListNode reverse(ListNode o1) {
        ListNode prev = null;//反转后的新链表
        ListNode curr = o1;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    //返回中间节点：双指针
    private ListNode middle(ListNode p) {
        ListNode slow = p;
        ListNode fast = p;
        // slow一次走一步，fast一次走两步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 最后的slow就指向中间节点
        return slow;
    }
}
