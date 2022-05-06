package tulingxueyuan;

public class QuickSort {
    /*
    *arr需要排序的数组
    * low开始排序的数组的最左边的索引low=0
    * high开始时最左边的索引=arr.length-1;
    * */
    public static void quickSort(int[]arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;//左边哨兵的索引
        j=high;//右边哨兵的索引
        //temp就是基准位
        temp=arr[low];//以最左边为基准位，基准位
        while(i<j){
            //先看右边，依次往左递减
            /*先从右往左找一个小于基准位的数
            当右边的哨兵位置所在的数>大于基准位数时
            继续从右往左找（同时j索引-1)
            找到后会跳出循坏
            * */
            while(temp<=arr[j]&&i<j){
                j--;
            }
            //再看左边，依次往右递增
            //步骤和上面类似
            while(temp>=arr[i]&&i<j){
                i++;
            }
            /*如果满足条件则交换*/
            if(i<j){
                /*z,y都是零时参数，用于存放左右哨兵所在位置的数据*/
                int z=arr[i];
                int y=arr[j];
                //左右哨兵交换数据(互相持有对方的数据)
                arr[i]=y;
                arr[j]=z;
            }
        }
        /*这是跳出了“while(i<j){}”循坏
        说明了i=j再统一位置
        最后将基准为i和j相等的位置的数字交换
        * */
        arr[low]=arr[i];//或是arr[low]=arr[j];
        arr[j]=temp;//arr[j]=temp;
        /*
        * i=j
        * 这时左半数组<(i或j所在索引的数)<右半数组
        * 也就是说(i或j所在索引的数)已经确定排序位置，所以就不用再排序了
        * 只要用相同的方法分别处理左右数组就可以了
        * */
        //递归调用左半数组
        quickSort(arr,low,j-1);
        //递归调用右半数组
        quickSort(arr,j+1,high);
    }

}
