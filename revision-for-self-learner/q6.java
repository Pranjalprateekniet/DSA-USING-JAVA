public class q6 {
    private ListNode sortlist(ListNode head){
        ListNode temp=head;
        ListNode zerohead=new ListNode(-1);
        ListNode onehead=new ListNode(-1);
        ListNode twohead=new ListNode(-1);
        ListNode zero=zerohead;
        ListNode one =onehead;
        ListNode two=twohead;
        while(temp!=null){
            if(temp==0)
            {
                zero.next=temp;
                zero=temp;

            }
            else if(temp==1)
            {
                one.next=temp;
                one=temp;

            }
            else{
                two.next=temp;
                two=temp;
            }
            temp=temp.next;

        }
        zero.next=(onehead.next!=null)?onehead.next:twohead.next;
        one.next=two.next;
        two.next=null;
        ListNode newhead=zerohead.next;
        return newhead.next;
        
    }
    
}
