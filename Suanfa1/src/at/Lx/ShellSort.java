    package at.Lx;
import java.util.Arrays;
public class ShellSort {
    public static void main(String[] args) {
        int[]a={2,4,1,5,36,7,77,55};
        sort1(a);
        // int[8]a1={};
        /*  mergesort(a,0,7,a);*/
        for (int i = 0; i < a.length-1; i++) {
            System.out.print(a[i]+"-");
        }

    }
    //插入排序=====================================
    public static void sort1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int value = arr[i];
            int j = 0;//插入的位置
            for (j = i-1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插入数据
        }
    }
    //================================================================================
    //计数排序
    private static int findMaxElement(int[] array){
        int max=array[0];
        for(int val:array){
            if(val>max){
                max=val;
            }
        }
        return max;
    }
    private static int[] countingSort(int[]array,int range){
        int[]output=new int[array.length];
        int[]count=new int[range];
        //初始化:count1数组
        for(int i=0;i<array.length;i++){
            count[array[i]]++;
        }
        //计数:count2数组，累加次数后的，这里用count2区分
        for(int i=1;i<range;i++){
            count[i]=count[i]+count[i-1];
        }
        //排序:最后数组
        for(int i=0;i<array.length;i++){
            output[count[array[i]]-1]=array[i];
            count[array[i]]--;
        }
        return output;
    }
    //================================================================================
    //堆排序
    public static void sort(int[]arr){
        int length=arr.length;
        //构建堆
        buildHeap(arr,length);
        for(int i=length-1;i>0;i--){
            //将堆顶元素与末尾元素调换
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            //数组长度-1，隐藏堆尾元素
            length--;
            //将堆顶元素下层，目的是将最大的元素浮到堆顶来
            sink(arr,0,length);

        }
    }
    private static void buildHeap(int arr[],int length){
        for(int i=length/2;i>=0;i--){
            sink(arr,i,length);
        }
    }
    private static void sink(int[] arr,int index,int length){
        int leftChild=2*index+1;//左子节点下标
        int rightChild=2*index+2;//右子节点下标
        int present=index;//要调整的节点的下标
        //下沉左边
        if(leftChild<length&&arr[leftChild]>arr[present]){
            present=leftChild;
        }
        //下沉右边
        if(rightChild<length && arr[rightChild]>arr[present]){
            present=rightChild;
        }
        //如果下表相等 证明调换过了
        if(present !=index){
            //交换值
            int temp=arr[index];
            arr[index]=arr[present];
            arr[present]=temp;
            //继续下沉
            sink(arr,index,length);
        }
    }
    //=================================================================================
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
             //此时说明右边序列还有剩余元素
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
    //========================
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
