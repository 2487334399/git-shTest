package com.company.two;

public class Num {
    public static int[] twoSum(int[]nums,int target){
        int[]result=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[]arr={1,5,2,55,7};
        twoSum(arr,62);
    }
}
