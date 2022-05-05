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
}
