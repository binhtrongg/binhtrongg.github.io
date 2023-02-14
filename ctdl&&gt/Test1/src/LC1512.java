public class LC1512 {
//    tìm cặp số tốt
//    điều kiện i<j và nums[i]=nums[j]
//    í tưởng :for trâu
    public int numIdenticalPairs(int[] nums) {
        int count=0;//tạo biến đếm
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {//    j luôn lớn hơn i
                if (nums[i]==nums[j]){
                    count++;
//                    nếu 2 giá trị bằng nhau thì biến đêm tăng lên 1
                }
            }
        }
        return count;
    }
}
