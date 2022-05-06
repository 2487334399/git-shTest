package tulingxueyuan;

public class BinarySort {
    public void sort(int []array){
        for(int i=1;i<array.length;i++){
            int temp=array[i];
            int low=0,high=array.length-1;
            int mid=-1;
            while(low<=high){
                mid=low+(high-low)/2;
                if(array[mid]>temp){
                    high=mid-1;
                }else{//元素相同时，也插入在后面的位置
                    low=mid+1;
                }
            }
            for(int j=i-1;j>low;j--){
                array[j+1]=array[j];
            }
            array[low]=temp;
        }
    }
}
