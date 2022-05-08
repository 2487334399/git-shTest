package tulingxueyuan;

import java.util.ArrayList;
import java.util.Collections;
/*
* 桶排序：将一组数分成若干份，然后利用数求出每份之间的范围差，然后将在符合范围的数进行插入，因为存在不断地插入数，所以可以使用LinkList和ArrayList链表来进行对桶数的存储和桶内数的存储。
过程：首先找出数中的最大值和最小值，然后求出桶数和间隔数，之后创建链表将桶数存入，将数中的每个数存入到对应的桶内，对每个桶内进行排序，从0号桶开始，将每个桶内排好顺序的数放入到一个新的数组中，最后打印数组即可

桶数计算：(max-min)/数组长度+1
间隔数：(max-min+1)/数组长度
————————————————
版权声明：本文为CSDN博主「小波（学习版）」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_54174102/article/details/123392174
* https://blog.csdn.net/weixin_54174102/article/details/123392174?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165193403616781483713250%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=165193403616781483713250&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduend~default-1-123392174-null-null.142^v9^pc_search_result_control_group,157^v4^control&utm_term=%E6%A1%B6%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95java&spm=1018.2226.3001.4187*/
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
