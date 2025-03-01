import publicclass.ListNode;

/**
 * @version v1.0
 * @author OldGj 2025/3/1
 * @apiNote 21. 合并两个有序链表
 */
public class _027_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 哨兵节点
        ListNode p = new ListNode(-1, null);
        // 新链表
        ListNode list3 = p;
        while (list1 != null && list2 != null) {
            // 哪个链表节点小，新链表的next节点就是哪个节点
            if (list1.val < list2.val) {
                list3.next = list1;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list2 = list2.next;
            }
            // 继续
            list3 = list3.next;
        }
        // 如果list1为null，则list2可能还有剩余节点
        if (list1 == null) {
            list3.next = list2;
        }
        // 同理
        if (list2 == null) {
            list3.next = list1;
        }
        return p.next;
    }

    /*
        合并两个有序链表
     */
    public ListNode mergeTwoLists2(ListNode p1, ListNode p2) {
        if (p1 == null) {
            return p2;
        }
        if (p2 == null) {
            return p1;
        }

        if (p1.val < p2.val) {
            // 如果p1节点小，p1节点的next就是合并 p1.next和p2这两个链表之后的链表
            p1.next = mergeTwoLists(p1.next, p2); // 固定一个值，合并剩下的
            return p1;
        } else {
            // 如果p2节点小，p2节点的next就是合并 p2.next和p1这两个链表之后的链表
            p2.next = mergeTwoLists(p1, p2.next);
            return p2;
        }
    }
}
