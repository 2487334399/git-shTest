package tulingxueyuan;

public class mergeSort {

    public static int[] merge(int[] a,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            // 左边归并排序
            sort(a, low, mid);
            // 右边归并排序
            sort(a, mid + 1, high);
            // 合并两个有序数组
            merge(a, low, mid, high);

        }
        return a;
    }
    public static void sort(int[]a,int low,int mid,int high){
        int[]temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=high){
            //对比大小，调整顺序
            if(a[i]<a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        //左边剩余元素填进temp中（因为前面已经归并，剩余的元素必会小于右边的元素)
        while(i<=mid){
            temp[k++]=a[i++];
        }
        //右边剩余元素充进temp中（因为前面已经归并，剩余的元素必会大于左边剩余的元素)
        while(j<=high){
            temp[k++]=a[j++];
        }
        //调整数组顺序
        for(int x=0;x<temp.length;x++){
            a[low+x]=temp[x];
        }
    }

}
