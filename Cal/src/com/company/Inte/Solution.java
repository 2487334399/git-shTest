package com.company.Inte;

import java.util.Arrays;

public class Solution {
   /* public static void main(String[] args) {
        Solution solution=new Solution();
    }
    public void merge(int[]nums1,int m,int[]nums2,int n){
        for(int i=0;i<n;++i){
            nums1[m+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }*/
     public static void merge(int[] nums1,int m,int[] nums2,int n){
         int k=m+n;
         int[]temp=new int[k];
         for(int index=0,nums1Index=0,nums2Index=0;index<k;index++){
             if(nums1Index>=m){/*nums1数组以及取完，完全取nums2数组的值即可*/
                temp[index]=nums2[nums2Index++];
             }else if(nums2Index>=n){/*nums2数组已经取完，完全取nums1数组的值即可*/
                 temp[index]=nums1[nums1Index++];
             }else if(nums1[nums1Index]<nums2[nums2Index]){
                 /*nums1数组的元素值小于nums2数组,取nums1数组的值*/
                 temp[index]=nums1[nums2Index++];
             }else{/*nums2数组的元素值小于等于nums1左边数组,取nums2数组的值*/
                 temp[index]=nums2[nums2Index++];
             }
         }
         for(int i=0;i<k;k++){
             nums1[i]=temp[i];
         }
     }
}
