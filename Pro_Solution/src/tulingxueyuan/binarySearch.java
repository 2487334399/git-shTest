package tulingxueyuan;

public class binarySearch {
    //采用递归查找要寻找的数据
    public static int rescursionBinarySearch(int[]arr,int key,int low,int high){
        if(key<arr[low]||key>arr[high]||low>high){
            return -1;
        }
        int middle=(high+low)/2;//初始中间位置
        if(arr[middle]>key){
            //比关键字大则在关键字在左区域
            return rescursionBinarySearch(arr,key,low,middle-1);
        }else if(arr[middle]<key){
            return rescursionBinarySearch(arr,key,middle+1,high);
        }else{
            return middle;
        }

    }
    //采用非递归的方式进行查找
    public static int commonBinarySearch(int[]arr,int key){
        int low =0;
        int high=arr.length-1;
        int middle=0;
        if(key<arr[low]||key>arr[high]||low>high){
            return -1;
        }
        while(low<=high){
            middle=(low+high)/2;
            if(arr[middle]>key){
                //比关键字大的则在关键字在左边区域
                high=middle-1;
            }else if(arr[middle]<key){
                low=middle+1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
