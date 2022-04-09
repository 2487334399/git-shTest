package com.company.two;

import java.util.HashMap;
import java.util.Map;

public class Num {
    public static void main(String[] args) {
        int[]arr={1,5,2,55,7};
        twoSum(arr,62);
    }
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
    //两个数之和得到优化
    public int[] twoSum1(int[]nums,int target){
        /*key为元素值，value为每个元素对应的下标*/
        Map<Integer,Integer> storeNums=new HashMap<>(nums.length,1);
        int[]result=new int[2];
        for(int i=0;i< nums.length;i++){
            int another=target-nums[i];
            Integer anotherIndex=storeNums.get(another);
            if(null!=anotherIndex){
                result[0]=anotherIndex;
                result[i]=1;
                break;
            }else{
                storeNums.put(nums[i],i);
            }
        }
        return result;
    }
}
