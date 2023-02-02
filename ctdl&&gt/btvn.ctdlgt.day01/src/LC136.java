import java.util.Arrays;

public class LC136 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,2,1,2,1}));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i<nums.length-1;i+=2) {
            if(nums[i]!=nums[i+1]) {
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }
}