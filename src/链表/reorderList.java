package 链表;

import java.util.List;

public class reorderList {
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        ListNode one = head;
        ListNode two = head.next;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next !=null?two.next.next:two.next;
        }
        ListNode dummy = new ListNode();
        ListNode temp = one.next;
        one.next = null;
        one = temp;
        while (one != null) {
            temp = one.next;
            one.next = dummy.next;
            dummy.next = one;
            one = temp;
        }
        dummy = dummy.next;
        ListNode current = head;
        while (dummy != null) {
            temp = dummy.next;
            dummy.next = current.next;
            current.next = dummy;
            current = dummy.next;
            dummy = temp;
        }
    }

    public static void main(String[] args) {
        reorderList a = new reorderList();
        a.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))));
    }
}
