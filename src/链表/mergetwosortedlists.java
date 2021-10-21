package 链表;

public class mergetwosortedlists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode current = dummyHead;
        while (l1.next != null || l2.next != null) {
            if (l1 == null || l1.val > l2.val) {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
                continue;
            }
            current.next = l1;
            current = current.next;
            l1 = l1.next;
        }
        return dummyHead.next;
    }
}
