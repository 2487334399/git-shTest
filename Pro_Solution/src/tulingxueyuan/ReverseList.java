package tulingxueyuan;

public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode preNode=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=preNode;
            preNode=curr;
            curr=next;
        }
        return preNode;
    }
}
