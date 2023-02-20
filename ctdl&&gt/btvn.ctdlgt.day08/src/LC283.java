public class LC283 {
//    độ phức tạp thời gian là O(n) với n là số phần tử của mảng do chỉ sd vòng lặp
//    độ phức tạp không gian là o(1) do chỉ thao tác với mảng có sẵn,không sd extra space
    public void moveZeroes(int[] nums) {
      int k=0;
        for (int i = 0; i <nums.length; i++) {
            if (nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        while (k< nums.length){
            nums[k]=0;
            k++;
        }
    }
}
