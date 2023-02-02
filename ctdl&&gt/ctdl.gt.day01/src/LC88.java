public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//m:độ dài dãy nums1
//m-1:phần tử cuối cùng
//        Tìm vị trí cần insert
        int lengthOfOne=m;
        int lengthOfTwo=n;
        for (int i=0;i<nums2.length-1;i++){
            for (int j=0;j<lengthOfOne;j++){
                if (nums2[i]<nums1[j]) {
                    insert(j, nums2[i], lengthOfOne, nums1);
                    lengthOfOne++;
                    lengthOfTwo--;
                    break;
                }
            }
        }
        if (lengthOfTwo>0){
            int index=m+n-lengthOfTwo;
            while (index<m+n){
                nums1[index]=nums2[n-lengthOfTwo];
                index++;
                lengthOfTwo--;
            }
        }
    }

    private void insert(int index, int number, int lengthOfOne, int[] arr) {
        for (int i = lengthOfOne; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = number;
    }
}
