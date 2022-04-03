package at.Lx;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[]arr={3,1,5,7,6,9};
        insertSort(arr);
    }
    public static void insertSort(int array[]){
        for (int i = 0; i <array.length-1 ; i++) {
            int index=i;//标记为第一个特殊的数字
            for(int j=i+1;j< array.length;j++){
                if(array[j]<array[index]){//如果小，就交换最小值
                    index=j;//保存最小元素的小标
                }
            }
            int temp=array[index];
            array[index]=array[i];
            array[i]=temp;

        }
        System.out.println(Arrays.toString(array));
    }
}
