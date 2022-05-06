package tulingxueyuan;
/*快速排序分区方法*/
public class Spaetition {
   private static void quickSort(int[]arr,int leftIndex,int rightIndex){
         if(leftIndex>=rightIndex){
             return ;
         }
         int left=leftIndex;
         int right=rightIndex;
         /*待排序的第一个元素作为基准值*/
       int key=arr[left];
       //从左右两边交替扫描，直到left=right
       while(left<right){
           while(right>left&&arr[right]>=key){
               //从右往左扫描，找到一个比基准值小的元素
               right--;
           }
           //找到这种元素将arr[right]放入arr[left]中
           arr[left]=arr[right];
           while(left<right&&arr[left]<=key){
               //从左往右扫描，找到第一个比基准值大的元素
               left++;
           }
       }
       //基准值归位
       arr[left]=key;
       //对基准值左边的元素进行递归排序
       quickSort(arr,leftIndex,left-1);
       //对基准值右边的元素进行递归排序
       quickSort(arr,right+1,rightIndex);
   }
}
