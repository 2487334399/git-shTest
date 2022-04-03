package at.Lx;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int a[]={3,44,38,5,47,1536,26,27,2,46,4,19,50,40};
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
