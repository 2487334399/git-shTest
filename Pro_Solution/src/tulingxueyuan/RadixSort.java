package tulingxueyuan;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radisSort(arr);
    }
    private static void radisSort(int[] arr){
        /*得到数组中最大的数的位数*/
        int max=arr[0];//假设第一个数是最大数
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }

        //得到最大数是几位数
        int maxLength=(max+"").length();
        //定义一个二维数组，表示10个桶，每个桶就是一个以为数组

        /*
        * 说明
        * 1、二维数组包含了10个一维数组
        * 2、为了防止在放入数的时候，数据溢出，则每个一维数组(桶),大小定为arr.length
        * 3、基数排序是使空间换时间的经典算法
        * */
        int[][]bucket=new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少数据，我们定义一个一维数组来记录各个桶中每次存放的数据个数
        //比如：bucketElementCounts[0],记录的就是bucket[0]桶的放入数据个数
        int[] bucketElementCounts=new int[10];

        //我们这里使用循环处理将代码处理
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //针对每个元素的对应位进行排序处理，第一个是个位，第二个是十位，第三个是百位
            for(int j=0;j<arr.length;j++){
                //取出每个元素的对应位的值
                int digitOfElement=arr[j]/n%10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原数组)
            int index=0;
            //遍历每一个桶，并将桶中的数据，放入到原数组
            for(int k=0;k<bucketElementCounts.length;k++){
                //如果桶中有数据，我们才放入到原数组
                if(bucketElementCounts[k]!=0){
                    //循环该桶即第k个桶（即第k个一维数组），放入
                    for(int l=0;l<bucketElementCounts[k];l++){
                        //取出元素放入到arr
                        arr[index++]=bucket[k][l];
                    }
                }
                //第i+1论处理后，需要将每个bucketElementCounts[k]=0!!!
                bucketElementCounts[k]=0;
            }
            System.out.println("第"+(i+1)+"轮，对各位的排序处理arr="+ Arrays.toString(arr));
        }
    }
}
