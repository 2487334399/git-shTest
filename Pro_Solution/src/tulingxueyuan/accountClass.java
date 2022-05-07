package tulingxueyuan;

public class accountClass {
    /*
    * 计数排序
    * 问题:数组有复数，不能解决
    */
    public static int[] sort(int[] arr){
        if(arr.length<2){
            return arr;
        }
        //创建辅助数组，数组大小为原数组的最大值
        int[] helper=new int[maxOf(arr)];
        for(int e:arr){
            //将原数组的元素作为辅助数组的下标，出现一次次数加一
            helper[e]++;
        }
        //数据回填的位置
        int current=0;
        //遍历辅助数组
        for(int i=0;i<helper.length;i++){
            /*当前元素出现次数大于1，依次赋给原数组*/
            while(helper[i]>0){
                //每次赋值后，指针右移
                arr[current++]=i;
                helper[i]--;
            }
        }
        return arr;
    }
    /*求数组中的最大值*/
    public static int maxOf(int[]arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[max]){
                max=i;
            }
        }
        return arr[max];
    }
}
