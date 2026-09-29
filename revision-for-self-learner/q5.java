class ListNode{
    int val;
    ListNode next;
    ListNode(int data){
        this.val=data;
        next=null;

    }
}
public class q5 {
    private ListNode segregatenodes(ListNode head){
        ListNode curr=head;
        if(head==null || head.next==null)
            return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenhead=head.next;
        while(odd!=null || even!=null){
            odd.next=odd.next.next;
            odd=odd.next;
            even.next=even.next.next;
            even=even.next;
        }
        odd.next=evenhead;
        return head;
    }
}
