package tulingxueyuan;

public class isPalindrome {
    public boolean isPalindrome(ListNode head){
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        /*如果链表是奇数个节点，把正中的归到左边*/
        if(fast!=null){
            slow=slow.next;
        }
        slow=reverse(slow);
        fast=head;

        while(slow!=null){
            if(fast.val!=slow.val){
                return false;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return true;
    }
    /*反转链表*/
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}
