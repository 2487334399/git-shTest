package tulingxueyuan;

public class RecursionBinarySearch {

    public static int recursionBinarySearch(int[]arr,int key,int low,int high){
        if(key<arr[low]||key>arr[high]||low>high){
            return -1;//没有要找的数字
        }
        int middle=(low+high)/2;
        if(arr[middle]>key){
            //比关键字大则在关键字左边区域
            return recursionBinarySearch(arr,key,low,middle-1);
        }else if(arr[middle]<key){
            //比关键字小则在关键字有区域
            return recursionBinarySearch(arr,key,middle+1,high);
        }else{
            return middle;
        }
    }
}
