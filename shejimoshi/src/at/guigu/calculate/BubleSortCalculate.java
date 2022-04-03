package at.guigu.calculate;
public class BubleSortCalculate {

    public static void main(String[] args) {
        Integer[]array={1,5,2,3,8,4,10,9};
        selectionSort(array);

    }
    //冒泡排序
    public static void bubleSort(int array[]){

        for(int j=array.length-1;j>0;j--){
            for (int i = 1; i <= j; i++) {
                if(array[i]<array[i-1]){
                    int temp=array[i];
                    array[i]=array[i-1];
                    array[i-1]=temp;
                }
            }
        }
    }
    public static void bubleSort1(int array[]){

        for(int j=array.length-1;j>0;j--){
            boolean sort=true;
            for (int i = 1; i <= j; i++) {
                if(array[i]>array[i-1]){
                    int temp=array[i];
                    array[i]=array[i-1];
                    array[i-1]=temp;
                    sort=false;
                }
            }
            if(sort) break;
        }


        for (int i = 0; i < array.length; i++) {
            System.out.print("-"+array[i]);
        }
    }
    //选择排序
    public static void selectionSort(Integer[] array){
           for(int end=array.length-1;end>0;end--){
               int maxIndex=0;
               for(int begin=1;begin<=end;begin++){
                   if(array[maxIndex]<=array[begin]){
                       maxIndex=begin;
                   }
               }
               int tmp=array[maxIndex];
               array[maxIndex]=array[end];
               array[end]=tmp;
           }
           for(int i=0;i<= array.length;i++){
               System.out.println(array[i]+"---");
           }
    }
}
