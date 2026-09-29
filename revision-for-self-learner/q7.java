public class q7 {
    private ListNode deletenode(ListNode head,int n){
        ListNode temp=head;
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;

        }
        if(fast==null)
            return head.next;
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;

        }
        ListNode deletenode=slow.next;
        slow.next=slow.next.next;
        return head;
    }
}
