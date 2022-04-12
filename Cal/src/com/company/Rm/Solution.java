package com.company.Rm;

public class Solution {

    public ListNode deleteDuplicates(ListNode head){
        if(head==null){
            return head;
        }
        ListNode currentNode=head;
        while(null!=currentNode){
            if(currentNode.next.val==currentNode.val){
                currentNode.next=currentNode.next.next;
            }else{
                currentNode=currentNode.next;
            }
        }
        return head;
    }
    /*递归处理，在本质上其实就是将链表压栈后倒序处理了*/
    public ListNode deleteDuplicates(ListNode head){
        if(head==null|| head.next==null) return head;
        head.next=deleteDuplicates(head.next);
        return head.val==head.next.val? head.next==head;
    }
}
