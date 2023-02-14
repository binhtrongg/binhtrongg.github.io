public class LC367 {
    //    Kiểm tra 1 số có phải số chính phương không(số cp là bình phương của 1 số nguyên)
//    ->binary search
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
//       0 và 1 đều là số chính phương
        }
        long left=0;
        long right=num/2;
//        chọn num/2 vì căn bậc 2 của n luôn <=n/2->thu hẹp khoảng cần tìm
        while (left <= right) {
            long mid = left + (right - left)/2;//chọn điểm chia đôi mảng
            long guessNum = mid * mid;//biến để so sánh với giá trị nums
            if (guessNum == num) {
                return true;
            } else if (guessNum > num) {
//                Nếu guess lớn hơn num, tìm kiếm từ left đến mid - 1.(khoảng bên trái)
//                ngược lại, tìm kiếm từ mid + 1 đến right.(khoảng bên phải
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
