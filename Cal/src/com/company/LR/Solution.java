package com.company.LR;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[]arr={1,3,5,2,3,3,7,5};
        findDisappearedNumbers(arr);

    }
    public static List<Integer> findDisappearedNumbers(int[] nums){
        int n= nums.length;
        for(int num:nums){
            int x=(num-1)%n;/*对n取模还原出它本来的值*/
            nums[x]+=n;
        }
        List<Integer>result=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(nums[i]<=n){
                result.add(i+1);
            }
        }
        for(int a:result){
            System.out.println(a);
        }
        return result;
    }

}
