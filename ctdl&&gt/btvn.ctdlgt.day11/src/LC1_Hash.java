import java.util.HashMap;

public class LC1_Hash {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hashMap=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int a=target-nums[i];
            if (hashMap.containsKey(a)){
                return new int[]{hashMap.get(a),i};
            }
            hashMap.put(nums[i],i );
        }
        return null;
    }
}
