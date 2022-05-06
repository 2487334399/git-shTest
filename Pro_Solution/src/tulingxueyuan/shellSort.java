package tulingxueyuan;

public class shellSort {

   public static int[] sort(int[] ins){
       int n = ins.length;
       int gap = n/2;
       while(gap > 0){
           for(int j = gap; j < n; j++){
               int i=j;
               while(i >= gap && ins[i-gap] > ins[i]){
                   //这一步其实就是值进行交换
                   int temp = ins[i-gap]+ins[i];
                   ins[i-gap] = temp-ins[i-gap];
                   ins[i] = temp-ins[i-gap];
                   i -= gap;
               }
           }
           gap = gap/2;
       }
       return ins;


   }
}
