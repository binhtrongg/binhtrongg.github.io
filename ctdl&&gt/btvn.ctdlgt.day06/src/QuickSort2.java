import java.util.Arrays;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] a={9,7,5,8,4,1,2};
        quickSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
    private static void quickSort(int[]arr,int low,int hight){
        if (low<hight){
            int sorttedItem=partition(arr,low,hight);
            quickSort(arr, low, sorttedItem-1);
            quickSort(arr,sorttedItem+1,hight);
        }
    }
     static int partition (int[] arr, int low, int high)
    {
        int pivot = arr[high];    // khai báo phần tử đánh dâu pivot
        int left = low;   //khai báo biến bên trái
        int right = high - 1; //khai báo biến bên phải
        while(true){
            while(left <= right && arr[left] < pivot) left++; // tìm phần tử >= phần tử pivot trong mảng
            while(right >= left && arr[right] > pivot) right--; // tìm phần tử <= phần tử pivot trong mảng
            if (left >= right) break; // sau khi duyệt xong thì thoát khỏi vòng lặp
            swap(arr,left, right); // nếu chưa xong thì sử dụng hàm swap() để tráo đổi.
            left++; // Vì left hiện tại đã xét, nên cần tăng
            right--; // Vì right hiện tại đã xét, nên cần giảm
        }
        swap(arr,left, high);
        return left; // Trả về chỉ số sẽ dùng để chia đôi mảng
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
