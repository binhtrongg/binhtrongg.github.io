public class LC35_Binary {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        int mid=(right-left)/2;
        while (left>right){
            if (mid==target){
                return target;
            }
            if (mid>target){
                right=mid-1;
            }
            else if (mid<target){
                left=mid+1;
                if (target>nums[nums.length-1]){
                    return nums.length-1+(target-nums[nums.length-1]);
                }
            }
        }
        return -1;
    }
}
