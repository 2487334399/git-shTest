package tulingxueyuan;

public class KthFromTail_Offer22 {
    public static ListNode kthNodeFromEnd(ListNode head,int kthNode){
        if(kthNode<=0 || head==null) return null;
        ListNode pTemp=head,pKthNode=null;
        /*pTemp(沿着列表)移动了k-1次*/
        for(int count=1;count<kthNode;count++){
            if(pTemp!=null){
                pTemp=pTemp.next;
            }
        }
        while(pTemp!=null){
            if(pKthNode==null)
                pKthNode=head;
            else
                pKthNode=pKthNode.next;
            pTemp=pTemp.next;
        }
        if(pKthNode!=null){
            return pKthNode;
        }
        return null;
    }
}
