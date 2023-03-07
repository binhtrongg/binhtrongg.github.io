public class LC733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Nếu điểm ban đầu và điểm mới có cùng màu, trả về ma trận ban đầu
        if (image[sr][sc] == newColor) {
            return image;
        }
        // Thực hiện đổi màu cho điểm ban đầu
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
//    time:O(N)->N là số Ô
//    space:0(N)
    public void dfs(int[][] image, int i, int j, int color, int newColor) {
        // i,j >kích thước ma trận,hoặc màu hiện tại khác màu ban đầu->end
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color) {
            return;
        }

        // Thực hiện đổi màu cho ô hiện tại
        image[i][j] = newColor;

        // đổi màu ô lân cận
        dfs(image, i + 1, j, color, newColor); //  phải
        dfs(image, i - 1, j, color, newColor); //  trái
        dfs(image, i, j + 1, color, newColor); //  dưới
        dfs(image, i, j - 1, color, newColor); //  trên
    }
}
