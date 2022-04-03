package at.Lx;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int a[]={3,44,38,5,47,15,36,26,27,2};
        int count=0;
        for (int i = 0; i < a.length-1; i++) {
            boolean flag=true;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    flag=false;
                }
                count++;
            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println("一共比较了:"+count+"次");


    }
}
