import java.util.LinkedList;
import java.util.Queue;

public class LC1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length; // chiều dài của ma trận maze
        int n = maze[0].length; // chiều rộng của ma trận maze
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // các hướng di chuyển có thể
        int steps = 0; // số bước đi
        Queue<int[]> queue = new LinkedList<>(); // tạo một hàng đợi để lưu các điểm cần duyệt
        queue.offer(entrance); // thêm điểm entrance vào hàng đợi
        maze[entrance[0]][entrance[1]] = '+'; // đánh dấu điểm entrance đã được duyệt

        while (!queue.isEmpty()) { // khi hàng đợi không rỗng
            int size = queue.size(); // lấy số lượng phần tử trong hàng đợi hiện tại
            for (int i = 0; i < size; i++) { // duyệt qua từng phần tử trong hàng đợi
                int[] curr = queue.poll(); // lấy phần tử đầu tiên trong hàng đợi và xóa nó khỏi hàng đợi
                int x = curr[0]; // tọa độ x của phần tử đang duyệt
                int y = curr[1]; // tọa độ y của phần tử đang duyệt

                if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && (x != entrance[0] || y != entrance[1])) {
                    // nếu phần tử đang duyệt nằm ở đường biên và không phải là entrance
                    return steps; // trả về số bước đi
                }

                for (int[] dir : directions) { // duyệt qua từng hướng di chuyển có thể
                    int dx = x + dir[0]; // tính tọa độ x mới
                    int dy = y + dir[1]; // tính tọa độ y mới

                    if (dx >= 0 && dx < m && dy >= 0 && dy < n && maze[dx][dy] == '.') {
                        // nếu tọa độ mới nằm trong ma trận và là điểm có thể đi được
                        maze[dx][dy] = '+'; // đánh dấu điểm mới đã được duyệt
                        queue.offer(new int[]{dx, dy}); // thêm điểm mới vào hàng đợi
                    }
                }
            }
            steps++; // tăng số bước đi sau khi đã duyệt xong một tầng của ma trận
        }
        return -1; // nếu không tìm thấy điểm exit nào thì trả về -1
//        time:o(mn)
//        space:o(m+n)
//        với m,n là số hàng và số cột của ma trận
    }
}
