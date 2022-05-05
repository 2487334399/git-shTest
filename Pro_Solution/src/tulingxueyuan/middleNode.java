package tulingxueyuan;
//返回列表中键的节点
public class middleNode {
    public ListNode middleNode(ListNode head){
        ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
           slow=slow.next;
           fast=fast.next.next;
        }
        return slow;
    }
}
