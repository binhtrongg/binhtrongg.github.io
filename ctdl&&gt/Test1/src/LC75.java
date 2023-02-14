import java.util.Arrays;

public class LC75 {
//    đề bài:yêu cầu sắp xếp mảng gồm các số nguyên thuộc tập {0, 1, 2} theo thứ tự tăng dần
//    ->sử uujng quickSort
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] arr, int low, int hight) {// gọi đệ quy để tiếp tục hia mảng
        if (low < hight) {
            int sorttedItem = partition(arr, low, hight);
            quickSort(arr, low, sorttedItem - 1);
            quickSort(arr, sorttedItem + 1, hight);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];    // khai báo phần tử đánh dâu pivot(chọn phần tử cuối)
        int left = low;   //khai báo biến bên trái
        int right = high - 1; //right bắt đầu từ vị trí cận pivot
        while (true) {
            while (left <= right && arr[left] < pivot) left++; // tìm phần tử >= phần tử pivot trong mảng
            while (right >= left && arr[right] > pivot) right--; // tìm phần tử <= phần tử pivot trong mảng
            if (left >= right) break; // sau khi duyệt xong thì thoát khỏi vòng lặp
            swap(arr, left, right); // nếu chưa duyệt xong thì sử dụng hàm swap() để đổi vị trí,sau đó tăng left giảm right để xét đén cặp tiếp theo
            left++; // Vì left hiện tại đã xét, nên cần tăng
            right--; // Vì right hiện tại đã xét, nên cần giảm
        }
        swap(arr, left, high);
        return left; // vị trí phần tử đầu tiên bên trái pivot,dùng để chia mảng
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
