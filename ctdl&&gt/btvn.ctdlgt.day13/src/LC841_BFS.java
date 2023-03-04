import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC841_BFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Khởi tạo BFS với phòng số 0
        visited[0] = true;
        queue.offer(0);

        // Bắt đầu duyệt BFS
        while (!queue.isEmpty()) {
            int currRoom = queue.poll();
            for (int nextRoom : rooms.get(currRoom)) {
                if (!visited[nextRoom]) {
                    visited[nextRoom] = true;
                    queue.offer(nextRoom);
                }
            }
        }

        // Kiểm tra xem tất cả các phòng đã được truy cập hay chưa
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false;
            }
        }
        return true;
    }






}
