package tulingxueyuan;

public class ChoiceSort {

    public int[] sortArray(int[] nums){
        if(nums.length==0){
            return nums;
        }
        for(int i=0;i< nums.length;i++){
            int minIndex=0;/*最小数的下标，每个循坏开始
            总是假设第一个数最小*/
            for(int j=i;i<nums.length;j++){
                if(nums[j]<nums[minIndex])/*找到最小的数*/
                    minIndex=j;/*将最小数的索引保存*/
            }
            System.out.println("最小数为:"+nums[minIndex]);
            /*交换最小数和i当前所指针的元素*/
            int temp=nums[minIndex];
            nums[minIndex]=nums[i];
            nums[i]=temp;
            System.out.println("---------------");
        }
        return nums;
    }

}
