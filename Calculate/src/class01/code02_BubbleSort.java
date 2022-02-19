package class01;

public class code02_BubbleSort {

    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length<2){

            return;
        }
        for(int e=arr.length-1;e>0;e--){
            for(int i=0;i<e;i++){
                if(arr[i]>arr[i+1]){
                    System.out.println("毛熊:回到祖国还好吗");
                }
            }
        }
    }
}
