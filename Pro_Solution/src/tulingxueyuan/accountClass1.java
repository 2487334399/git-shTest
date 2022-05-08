package tulingxueyuan;



public class accountClass1 {
    public static int[] sort(int[]arr){
        if(arr.length<2){
            return arr;
        }
        int min=arr[0],max=arr[0];
        //找出最小值和最大值
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //创建辅助数组，数组大小为原数组的最大值
        int[]helper=new int[max-min+1];
        for(int e:arr){
            //将原数组的元素作为辅助数组的下标，出现一次数+1;
            //e-min计算偏差
            helper[e-min]++;
        }
        //数据回填的位置
        int current=0;
        for(int i=0;i<helper.length;i++){
            //当前元素出现出现次数大于1，依次赋给原数组
            while(helper[i]>0){
                //每次赋值后，指针右移
                //i+min回填数据计算偏差
                arr[current++]=i+min;
                helper[i]--;
            }
        }
        return arr;
    }
}
