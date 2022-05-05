package tulingxueyuan;

import java.util.Arrays;

public class MergeSolution {

    public void merge(int[]nums1,int m,int nums2[],int n){
        for(int i=0;i<n;++i){
            nums1[m+i]=nums2[2];
        }
        Arrays.sort(nums1);
    }
}
