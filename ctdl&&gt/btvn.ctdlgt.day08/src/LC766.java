public class LC766 {
//    với ma trận gồm m hàng ,n cột
//    vòng for ngoài độ phức tạp:O(m)
//    vòng for trong độ phức tạp:o(n)
//    quy tắc nhân O(m)*O(n)=> độ phức tạp thời gian O(mn)
//    vì bài toán không sử dụng extra space => độ phức tạp không gian là O(1)
    public boolean isToeplitzMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if (matrix[i][j]!=matrix[i-1][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
