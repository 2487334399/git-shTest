package com.company.LL;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode resultNode = new ListNode(0);
        ListNode p = resultNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) ;
            p.next = l1;
            l1 = l1.next;
        }else{
            p.next = l2;
            l2 = l2.next;
        }
        p = p.next;
    }
        if(l1!=null)
        p.next=l1;
        if(l2!=null)
        p.next=l2;
        return resultNode.next;
  }
  //递归解决
  public ListNode mergeTwoList(ListNode l1,ListNode l2){
    if(l1==null)return  l2;
    if(l2==null)return  l1;
    if(l1.val<l2.val){
        l1.next=mergeTwoLists(L1.next,l2);
        return l1;
    }
    l2.next=mergeTwoList(l1,l2.next);
    return l2;
}
