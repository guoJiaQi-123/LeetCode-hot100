import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2025/2/24
 * @apiNote 京东一面
 */
public class Main {

    /*
        题目：设计单链表结构的对象，用于表示一个超大的正整数，链表的每个节点表示其中一位，链表从高位指向低位，比如正整数为123, 则链表结构为：1->2->3->null，题目要求：使用多线程对链表进行加1操作，输入是一个链表，输出还是链表。
     */
    
    public static void main(String[] args) {
        List<Integer> test = new Main().test(new LinkedList<>(List.of(9)));
        System.out.println(test);
    }

    public List<Integer> test(LinkedList<Integer> list) {
        int size = list.size();
        int t = 0;
        for (int i = size - 1; i >= 0; i--) {
            Integer x = list.get(i);
            x += t;
            t = 0;
            x++;
            if (x >= 10) {
                list.set(i, 0);
                t++;
                if (i == 0) {
                    list.addFirst(1);
                }
                continue;
            }
            if (i != size - 1) {
                list.set(i, --x + t);
            } else {
                list.set(i, x);
            }
        }
        return list;
    }
}


