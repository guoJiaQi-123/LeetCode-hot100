/*
    如果计算机具有多个 CPU 核心，多线程可以充分利用多核处理器的并行计算能力。对于一个非常长的链表，每个节点的加 1 操作相对独立，理论上可以同时对多个节点进行处理，从而减少整体的处理时间。
 */
// 定义单链表节点类
class ListNodeOne {
    int val;
    ListNodeOne next;

    ListNodeOne(int val) {
        this.val = val;
    }
}

// 定义一个线程类，用于处理链表节点的加 1 操作
class AddOneThread extends Thread {
    private ListNodeOne node;
    private boolean carry;

    public AddOneThread(ListNodeOne node) {
        this.node = node;
        this.carry = false;
    }

    public boolean getCarry() {
        return carry;
    }

    @Override
    public void run() {
        if (node != null) {
            if (node.val == 9) {
                node.val = 0;
                carry = true;
            } else {
                node.val++;
                carry = false;
            }
        }
    }
}

public class LargeIntegerAddOne {
    // 多线程对链表进行加 1 操作
    public static ListNodeOne addOne(ListNodeOne head) {
        if (head == null) {
            return new ListNodeOne(1);
        }

        // 反转链表，从低位开始处理
        ListNodeOne reversedHead = reverseList(head);
        ListNodeOne current = reversedHead;
        boolean carry = true;
        // 当前节点不为null且前一个节点计算有进位，或者是第一次计算
        while (current != null && carry) {
            // 对节点进行加一操作
            AddOneThread thread = new AddOneThread(current);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 判断是否有进位
            carry = thread.getCarry();
            current = current.next;
        }

        // 如果最后还有进位，需要在链表头部添加一个新节点
        if (carry) {
            ListNodeOne newNode = new ListNodeOne(1);
            newNode.next = reverseList(reversedHead);
            return newNode;
        }

        return reverseList(reversedHead);
    }

    // 反转链表
    private static ListNodeOne reverseList(ListNodeOne head) {
        ListNodeOne prev = null;
        ListNodeOne current = head;
        while (current != null) {
            // 记录下一个节点
            ListNodeOne nextNode = current.next;
            // 当前节点的next指向前一个节点
            current.next = prev;
            // 前一个节点后移
            prev = current;
            // 当前节点后移
            current = nextNode;
        }
        return prev;
    }

    // 打印链表
    public static void printList(ListNodeOne head) {
        ListNodeOne current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print("->");
            }
            current = current.next;
        }
        System.out.println("->null");
    }

    public static void main(String[] args) {
        // 创建链表 1->2->3->null
        ListNodeOne head = new ListNodeOne(8);
        head.next = new ListNodeOne(9);
        head.next.next = new ListNodeOne(1);

        System.out.println("原始链表:");
        printList(head);

        ListNodeOne result = addOne(head);

        System.out.println("加 1 后的链表:");
        printList(result);
    }
}