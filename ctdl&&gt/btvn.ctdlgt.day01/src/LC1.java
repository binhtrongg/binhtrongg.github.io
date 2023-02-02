public class LC1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    ints = new int[]{i, j};
                }
            }
        }
        return ints;
    }
}
