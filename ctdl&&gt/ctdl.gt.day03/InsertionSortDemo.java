package day03;

import java.util.Arrays;

public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] ar={20,5,4,6,8,10,7,9,30};
        insertionSort(ar);
        System.out.println(Arrays.toString(ar));
    }
    private static void insertionSort(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            int keyNumber=arr[i];
            int j=i-1;
//            vị trí bắt đầu duyệt mảng phía bên trái
            while (j>=0 && arr[j]>keyNumber){
                arr[j+1]=arr[j];
//                dịch sang bên phải để chèn
                j--;
            }
//            tại j,arr[j]<number
            arr[j+1]=keyNumber;
            System.out.println(i+" : "+Arrays.toString(arr));
        }
    }
}
