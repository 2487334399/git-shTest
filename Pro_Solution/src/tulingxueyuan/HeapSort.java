package tulingxueyuan;
import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int arr[]){
        int temp=0;
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHead(arr,i,arr.length);
        }
        /*将堆顶元素与末尾元素交换，将最大元素“沉”到数组末尾；
        * 重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素*/
        for(int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHead(arr,0,j);
        }
    }
    //将一个数组调整城一个大根堆
    public static void adjustHead(int arr[],int i,int length){
        int temp=arr[i];//先取出当前元素的值，保存在零时变量
        //开始调整
        //说明: k=i*2+1 k是i节点的左子节点
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if(arr[k]>arr[i]){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i]=temp;
    }

}

