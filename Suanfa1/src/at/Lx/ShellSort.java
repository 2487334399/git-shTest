    package at.Lx;
import java.util.Arrays;
public class ShellSort {
    public static void main(String[] args) {
        int[]a={2,4,1,5,36,7,77,55};

        mergesort(a,0,7,a);
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i]+"-");
        }

    }
    //===================   ===========================================
    public static void sort(int[]arr){
        int length=arr.length;
        //构建堆

        for(int i=length-1;i>0;i--){
            //将堆顶元素与末尾元素调换
            int temp=arr[0];
            arr[0]=arr[i];

        }
    }
    //==================================================================
    //归并排序
     public static void mergesort(int[]a,int left,int right,int[] temp){
        //分解
         if(left<right){
             int mid=(left+right)/2;
             //向左递归分解
             mergesort(a,left,mid,temp);
             //向右递归分解
             mergesort(a,mid+1,right,temp);
             //每分解一次便合并一次
             merge(a,left,right,mid,temp);

         }
     }
     public static void merge(int[]a,int left,int right,int mid,int[] temp){
         int i=left;//初始i,左边有序序列的初始索引
         int j=mid+1;//初始化j,右边有序序列的初始索引(右边有序序列的初始位置即中间位置的最后一位置)
         int t=0;//指向temp数组的当前索引，初始为0

         //先把左右两边的数据(已经有序)按规则填充到temp数组
         //直到左右两边的有序序列，有一边处理完为止
         while(i<=mid &&j<=right){
                //如果左边有序序列的当前元素小于或等于右边的有序序列的当前元素，就将左边的元素填充到temp数组中
             if(a[i]<a[j]){
                 temp[t]=a[i];
                 t++;//索引后移
                 i++;//i后移
             }else{
                 //反之，将右边有序序列的当前元素填充到temp数组中
                 temp[t]=a[j];
                 t++;//索引向后移
                 j++;//j后移
             }
         }
         //把剩余数据的一边的元素填充到temp中
         while(i<mid){
             //此时说明左边序列还剩余元素
             //全部填充到temp数组中
             temp[t]=a[i];
             t++;
             i++;
         }
         while(j<=right){
             //此时说明左边序列还有剩余元素
             //全部填充到temp数组中
             temp[t]=a[j];
             t++;
             j++;
         }
         //将temp数组的元素复制到原数组
         t=0;
         int tempLeft=left;
         while(tempLeft<=right){
             a[tempLeft]=temp[t];
             t++;
             tempLeft++;
         }

     }
     //================================================================================================
    //快速排序
    public static void quickSort(int[] a,int low,int high){
        int i,j;
        if(low>high){
            return;
        }
        i = low;
        j = high;
        int temp = a[low];//基准位，low=a.length时，会报异常，，所以必须在if判断后面，就跳出方法
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
