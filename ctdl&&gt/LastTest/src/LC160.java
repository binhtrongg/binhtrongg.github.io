public class LC160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode d1 = headA;
        ListNode d2 = headB;
        while ((d1 != null) || (d2 != null)) {
//            d1=null->đưa d1 về đầu headB
            if (d1 == null)
                d1 = headB;
//            d1=null->đưa d1 về đầu headA
            if (d2 == null)
                d2 = headA;
//            d1=d2-> đó là giao điểm,trả về 1 trong 2 deu dc
            if (d1 == d2)
                return d1;
            d1 = d1.next;
            d2 = d2.next;
        }
//        không thấy thì trả về null
        return null;
//        time=o(n) n là tổng số node
//        space:o(1)
    }
}
