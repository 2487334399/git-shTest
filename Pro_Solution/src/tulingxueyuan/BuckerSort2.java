package tulingxueyuan;

import java.util.ArrayList;
import java.util.Collections;

public class BuckerSort2 {

    public static void buckerSort(int[]a){
        int min=a[0];
        int max=a[0];
        for(int i=0;i<a.length;i++){
            max=Math.max(max,a[i]);
            min=Math.min(min,a[i]);
        }
        System.out.println("最大值为:"+max);
        System.out.println("最大值为:"+min);
        //桶数
        int bucketNum=a.length;
        //这里处理很巧妙
        //声明并初始化一个ArrayList,用来存放通的个数，以及桶中的数据
        ArrayList<ArrayList<Integer>>bucketArr=new ArrayList<>(bucketNum);
        for(int i=0;i<bucketNum;i++){
            bucketArr.add(new ArrayList<>());
        }
        //将每个元素放入桶中，
        for(int i=0;i<a.length;i++){
            //加1是为了保证index<a.length;防止程序出现异常
            //这里就是一个比例问题，就是看一下a[i]是属于哪一个桶的，因为这里的桶数是数组a的长度，
            int num=(int)((a[i]-min)/(max-min+1)*a.length);
            bucketArr.get(num).add(a[i]);
        }
        //对每个桶进行排序
        for(int j=0;j<bucketArr.size();j++){
            Collections.sort(bucketArr.get(j));
        }
        //合并数据
        int k=0;
        for(ArrayList<Integer>arr:bucketArr){
            for(int i:arr){
                a[k++]=i;
            }
        }
    }
}
