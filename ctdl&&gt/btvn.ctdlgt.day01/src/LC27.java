import java.util.Arrays;

public class LC27 {
    public static int removeElement(int[] nums, int val) {
        int n=0;
        for (int i = 0; i <nums.length-1 ; i++) {
            if(nums[i]!=val){
                nums[n]=nums[i];
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3},3));
    }
}
