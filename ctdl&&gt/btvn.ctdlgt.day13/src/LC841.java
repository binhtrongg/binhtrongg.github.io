import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer>visited=new HashSet<>();
        DFS(0,visited,rooms);
        return visited.size()==rooms.size();
    }
    private void DFS(int room, Set<Integer>visited,List<List<Integer>>rooms){
        visited.add(room);
        for (int nextRoom:rooms.get(room)) {
            if (!visited.contains(nextRoom)){
                DFS(nextRoom,visited,rooms);
            }
        }
    }
}