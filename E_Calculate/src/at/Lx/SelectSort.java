package at.Lx;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int a[]={1,44,38,5,47,156,26,27,2,46,4,19,50,40};
        shellSort(a);
    }
    public static void shellSort(int []a){
        int count=0;//比较次数
        for(int gap=a.length/2;gap>0;gap=gap/2){
            //将整个数组分为若干个子数组
            for(int i=gap;i<a.length;i++){
                //遍历各组的元素
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
    public static void SelectSort(int[]a){
        for(int i=0;i<a.length;i++){//长度不减一，是因为要多留一个位置方便插数
            //定义待插入的数字
            int insertValue=a[i];
            //找到待插入数的前一个数的下表，
            int insertIndex=i-1;
            while(insertIndex>=0&&insertValue<a[insertIndex]){//拿a[i]与a[i-1]的前面数组比较
                a[insertIndex+1]=a[insertIndex];
                insertIndex--;
            }
            a[insertIndex+1]=insertValue;
        }
        System.out.println(Arrays.toString(a));
    }
}
