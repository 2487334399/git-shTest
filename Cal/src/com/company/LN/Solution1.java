package com.company.LN;

public class Solution1 {
    public ListNode deleteCycle(ListNode head){
        if(head==null) return null;
        ListNode slowPtr=head,fastPtr=head;//定义快指针和慢指针
        boolean loopExists=false;          //定义是否存在
        while(fastPtr.next!=null&&fastPtr.next.next!=null){
            slowPtr =slowPtr.next;
            fastPtr=fastPtr.next;
            if(slowPtr==fastPtr){
                loopExists=true;
            }
        }
        if(loopExists){//环存在
            slowPtr=head;
            while(slowPtr!=fastPtr){
                fastPtr=fastPtr.next;
                slowPtr=slowPtr.next;
            }
            return slowPtr;//返回环的开始节点
        }
        return null;
    }
}
