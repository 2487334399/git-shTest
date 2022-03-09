package at.guigu.calculate;

public class BubleSortCalculate {

    public static void main(String[] args) {
        //好的计算
        int[] array={99,66,22,44,1,2,5,0,44};
        //第二轮进行排序
        for(int j= array.length-1;j>0;j--){
            for (int i = 1; i <=j; i++) {
                if(array[i]<array[i-1]){
                    int temp=array[i];
                    array[i]=array[i-1];
                    array[i-1]=temp;
                }
            }
        }
        //从第一轮进行排序
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"----");
        }
    }
}
