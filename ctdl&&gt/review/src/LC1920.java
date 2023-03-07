public class LC1920 {
    public int[] buildArray(int[] nums) {
//        0 2 1 3 5 4
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
            ans[i] = nums[nums[i]];
        return ans;
    }
}
