package com.company.LR;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
    }
    public static List<Integer> findDisappearedNumbers(int[] nums){
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;/*对n取模还原出它本来的值*/
            nums[x] += n;//加n,让已有数值的元素的下表的值大于数组元素个数
        }
        List<Integer>result=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(nums[i]<=n){//所以小于n的只有这里的两个元素
                result.add(i+1);
            }
        }
        for(int a:result){
            System.out.print(a+" ");
        }
        return result;
    }

}
