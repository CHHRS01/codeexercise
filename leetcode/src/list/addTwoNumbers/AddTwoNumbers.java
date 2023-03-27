package list.addTwoNumbers;

import entity.ListNode;

/**
 * 2. 两数相加
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {return  l2;}
        if (l2 == null) {return  l1;}
        int pro = l1.val + l2.val;
        l1.val = pro % 10;
        int add = pro / 10;
        ListNode head = l1;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            pro = l1.val + l2.val + add;
            l1.val = pro % 10;
            add = pro / 10;
        }
        if (l1.next == null) {
            l1.next = l2.next;
        }
        while (add == 1 && l1.next != null) {
            l1 = l1.next;
            pro = l1.val + add;
            l1.val = pro % 10;
            add = pro / 10;
        }
        if (add == 1) {
            l1.next = new ListNode(1);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l1_1 = new ListNode(3);
        l1.next = l1_1;

        ListNode l2 = new ListNode(6);
        ListNode l2_1 = new ListNode(6);
        ListNode l2_2 = new ListNode(9);
        l2.next = l2_1;
        l2_1.next = l2_2;

        addTwoNumbers(l1, l2);
        while (l1 != null) {
            System.out.print(l1.val);
            System.out.print(" ");
            l1 = l1.next;
        }
    }
}
