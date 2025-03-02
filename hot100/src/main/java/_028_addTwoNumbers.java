import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/3/2
 * @apiNote 2. 两数相加
 */
public class _028_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode curr = null;
        // 进位
        int carry = 0;
        // 有一个链表不为null就需要继续计算
        while (l1 != null || l2 != null) {
            // 取值
            int p1 = l1 != null ? l1.val : 0;
            int p2 = l2 != null ? l2.val : 0;
            // 计算和
            int sum = p1 + p2 + carry;
            // 构建新链表
            if (head == null) {
                head = curr = new ListNode(sum % 10);
            } else {
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }
            // 计算进位
            carry = sum / 10;
            // 移动到下一位
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果最后仍然有进位，需要新增一个链表保存
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }
        return head;
    }
}
