package day03;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] ar={2,5,6,8,7,9,30};
        bubbleSort(ar);
        System.out.println(Arrays.toString(ar));
    }
    private static void bubbleSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            boolean isSwap=false;
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    isSwap=true;
                }
            }
            System.out.println(i+" : "+Arrays.toString(arr));
            if (!isSwap){
                break;
            }
        }
    }
    private static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
