import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/2/25
 * @apiNote 160. 相交链表
 */
public class _020_getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 记录两个链表的头节点
        ListNode oldHeadA = headA;
        ListNode oldHeadB = headB;
        while (true) {
            // 如果两个节点相遇，则说明两个链表相交
            // 如果两个链表不相交，这两个节点也会同时指向null，从而返回null
            if (headA == headB) {
                return headA;
            }
            // 如果A链表遍历完了，则将指针指向B链表的头部继续遍历
            if (headA == null) {
                headA = oldHeadB;
            } else {
                headA = headA.next;
            }
            // 同理，这样的话，两个指针就会同时走到相交节点处，从而被上面headA == headB判断后返回
            if (headB == null) {
                headB = oldHeadA;
            } else {
                headB = headB.next;
            }
        }
    }
}
