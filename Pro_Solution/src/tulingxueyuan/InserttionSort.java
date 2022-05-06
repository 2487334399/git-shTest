package tulingxueyuan;

public class InserttionSort {

    public int[] sortArray(int[] nums){
        if(nums.length==0)
            return nums;
        int currentValue;/*当前待排序数据，该元素之前的元素均已经被排序*/
        for(int i=0;i<nums.length-1;i++){
            int preIndex=i;/*已被排序数据的索引*/
            currentValue=nums[preIndex+1];
            System.out.println("待排序元素的索引:"+(i+1)+",值为:"+currentValue+"已被排序的数据的索引"+preIndex);
            /*
            * 在已被排序过数据中倒排序寻找合适的位置，如果当前待排序数据比比较的
            * 元素要小*/
            while(preIndex>=0&&currentValue<nums[preIndex]){
                //将当前元素后移以为
                nums[preIndex+1]=nums[preIndex];
                preIndex--;
            }
            //while循坏结束时，说明已经找到了当前待排序数据的合适位置，插入
            nums[preIndex+1]=currentValue;
            System.out.println("本轮被插入排序后的数组");
            System.out.println("-----------------------------");
        }
        return nums;
    }
}
