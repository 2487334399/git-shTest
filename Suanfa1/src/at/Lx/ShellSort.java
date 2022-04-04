package at.Lx;
import java.util.Arrays;
public class ShellSort {
    public static void main(String[] args) {
          int[]a={2,4,1,5,36,7,77};
         // shellSort(a);
        quickSort(a,0,6);
        for(int i=0;i<=a.length-1;i++){
            System.out.print(a[i]+"-");
        }
    }
    public static void quickSort(int[] a,int low,int high){
        int i,j;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        int temp=a[low];//基准位，low=a.length时，会报异常，，所以必须在if判断后面，就跳出方法
        while(i<j){
            //先从右边开始往左递减，找到比temp小的值才停止
            while(temp<=a[j]&&i<j){
                j--;
            }
            //再看左边开始往右边递增找到比temp大的值才停止SE
            while(temp>=a[i]&&i<j){
                i++;
            }
            //满足i<j就交换，继续循坏while(i<j)
            if(i<j){
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
            }
        }
        //最后将基准位跟a[i]和a[j]相等的位置，进行交换，此时i=j;
        a[low]=a[i];
        a[i]=temp;
        //左递归
        quickSort(a,low,j-1);
        //右递归
        quickSort(a,j+1,high);

    }
    public static void shellSort(int[]a){
        int count=0;//计数交换的次数
        //把数组分为诺干个小数组
        for(int gap=a.length/2;gap>0;gap=gap/2){
            for(int i=gap;i<a.length;i++){
                for(int j=i-gap;j>=0;j=j-gap){
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
