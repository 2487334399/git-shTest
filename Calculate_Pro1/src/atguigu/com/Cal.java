package atguigu.com;

public class Cal {
    public static void main(String[] args) {
        int[]c={1,4,3,21,6,5,7};
        order1(c);

    }
    //冒泡排序
    public static void order1(int[] a){
        boolean hasSwap;
        for(int x=0;x<a.length-1;x++){
            hasSwap=false;
            for(int y=0;y< a.length-1-x;y++){
                if(a[y]>a[y+1]){
                    int t=a[y];
                    a[y]=a[y+1];
                    a[y+1]=t;
                    hasSwap=true;
                }
            }
            if(hasSwap==false) return;
        }
    }
}
