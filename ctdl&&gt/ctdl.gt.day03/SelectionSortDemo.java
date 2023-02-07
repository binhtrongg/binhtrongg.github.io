package day03;

import java.util.Arrays;

public class SelectionSortDemo {
    public static void main(String[] args) {
        int[] ar={20,5,4,6,8,10,7,9,30};
        Arrays.sort(ar);
selectionSort(ar);
        System.out.println(Arrays.toString(ar));
    }
    private static void selectionSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            int minIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
            System.out.println(i +" : "+Arrays.toString(arr));
        }
    }
    private static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
