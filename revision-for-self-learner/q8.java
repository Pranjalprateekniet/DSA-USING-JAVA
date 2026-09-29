import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    ListNode(){
        val=0;
        next=null;
    }
    ListNode(int data1){
        val=data1;
        next=null;

    }
    ListNode(int data1,ListNode next1){
        val=data1;
        next=next1;
    }
}


public class q8 {
    private static ListNode addtwonumbers(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp=dummy;
        int carry=0;
        while(l1!=null || l2!=null){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
                sum+=l2.val;
                l2=l2.next;

            }
            sum+=carry;
            carry=sum/10;
            ListNode node=new ListNode(sum%10);
            temp.next=node;
            temp=temp.next;

        }
        return dummy.next;
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

    }
}
