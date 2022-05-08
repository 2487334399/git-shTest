package tulingxueyuan;

import java.util.Scanner;

public class TestSequentialSearch {
    public static void SequentialSearch(int[]arr,int input){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==input){
                System.out.println(input+"的位置为:"+i);
                break;
            }
            if(i==arr.length-1){
                System.out.println("No Result");
            }
        }
    }

    public static void main(String[] args) {
        int a[]={46,38,65,97,76,13,27,49,78};
        System.out.println("请输入要查询的数字");
        Scanner input=new Scanner(System.in);
        int input1=input.nextInt();
        SequentialSearch(a,input1);
    }
}
