package tulingxueyuan;

public class InterSectionNode {
    /*
    * 给你两个单列表的头节点headA和headB
    * ,请你找出并返回单列表相交的起始节点，如果两个
    * 列表没有交点，返回null*/
    public ListNode getIntersection(ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode pA=headA,pB=headB;
        while(pA!=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
    public ListNode getInterSectionNode(ListNode headA,ListNode headB){
        int L1=0,L2=0,diff=0;
        ListNode head1=headA,head2=headB;
        while(head1!=null){
            L1++;
            head1=head1.next;
        }
        while(head2!=null){
            L2++;
            head2=head2.next;
        }
        if(L1<L2){
            head1=headB;head2=headA;diff=L2-L1;
        }else{
            head1=headA;head2=headB;diff=L1-L2;
        }
        for(int i=0;i<diff;i++){
            head1=head1.next;
            while(head1!=null&&head2!=null){
                if(head1==head2)
                    return head1;
                head1=head1.next;
                head2=head2.next;
            }

        }
        return null;
    }
}
