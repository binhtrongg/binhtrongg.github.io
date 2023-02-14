public class LC832 {
//    đề bài :cho mảng 2 chiều
//    đảo ngược các phần tử mỗi hàng,sau đó thay 0 thành 1,thay 1 thành 0
//    trả về mảng đã sắp xếp
public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            reverseRow(row);
            invertRow(row);
        }
        return image;
    }

    private void invertRow(int[] row) {//thay đổi giá trị
        for (int i = 0; i < row.length; i++){
            if (row[i]==0){
                row[i]=1;
            }
            else {
                row[i]=0;
            }
        }
    }
// hàm đảo ngược vị trí
    private void reverseRow(int[] row) {
        int p = 0, q = row.length - 1;
        while (p < q) {
            int temp = row[p];
            row[p++] = row[q];
            row[q--] = temp;
        }
    }
}
