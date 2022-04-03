package at.Lx;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
          int[]a={2,4,1,5,36,7,77};
          shellSort(a);
    }
    public static void shellSort(int[]a){
        int count=0;
        //将整个数组分为若干个数组
        for(int gap=a.length/2;gap>0;gap=gap/2){
            //遍历各组的元素
            for(int i=gap;i<a.length;i++){
                for(int j=i-gap;j>=0;j=j-gap){
                    //交换元素
                    if(a[j]>a[j+gap]){
                        int temp=a[j];
                        a[j]=a[j+gap];
                        a[j+gap]=temp;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(a));
    }
}
