package at.guigu.calculate;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class BubleSortCalculate {

    public static void main(String[] args) {


    }
    public static void bubleSort(@NotNull int array[]){

        for(int j=array.length-1;j>0;j--){
            for (int i = 1; i <= j; i++) {
                if(array[i]<array[i-1]){
                    int temp=array[i];
                    array[i]=array[i-1];
                    array[i-1]=temp;
                }
            }
        }
    }
    public static void bubleSort1(int array[]){

        for(int j=array.length-1;j>0;j--){
            boolean sort=true;
            for (int i = 1; i <= j; i++) {
                if(array[i]>array[i-1]){
                    int temp=array[i];
                    array[i]=array[i-1];
                    array[i-1]=temp;
                    sort=false;
                }
            }
            if(sort) break;
        }


        for (int i = 0; i < array.length; i++) {
            System.out.print("-"+array[i]);
        }
    }
}
