package tulingxueyuan;

import java.util.ArrayList;
import java.util.List;

public class findDisappearedNumber {
    /*
    * 给你一个含n个整数的数组nums,其中nums[i]在区间
    * 【1，n】内，请你找出所有在[1,n]范围内但没有出现在
    * nums中的数字，并以数组的形式返回结果
    * */
    public List<Integer> findDisappearedNumbers(int[]nums){
          int n=nums.length;
          for(int num:nums){
              int x=(num-1)%n;/*对n取模来还原
              出他本来的值,去除重复的值*/
              nums[x]+=n;
          }
          List<Integer>result=new ArrayList<Integer>();
          for(int i=0;i<n;i++){
              if(nums[i]<=n){
                  result.add(i+1);
              }
          }
          return result;
    }
}
