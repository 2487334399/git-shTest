package com.company;

public class Main {

    public static void main(String[] args) {
        int[]arr={11,2,4,5,1,5,35,66};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.print(arr[i]+"--");
        }

    }
}
