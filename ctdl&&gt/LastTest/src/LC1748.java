import java.util.HashMap;
import java.util.Map;

public class LC1748 {
    public int sumOfUnique(int[] nums) {
            // tạo hashmap lưu số làn xuất hiện của ele
            Map<Integer, Integer> map = new HashMap<>();

            // lưu số lần xuất hiện vào map
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int sum = 0;

            // tính tổng
            for (int num : nums) {
                if (map.get(num) == 1) {
                    sum += num;
                }
            }

            return sum;
        }
//        time:o(n)
//    space:O(n)
    }






