public class LC278{
    public static void main(String[] args) {
        System.out.println(firstBadVersion(1));
    }
    static boolean  isBadVersion(int version){
        return version>=2;
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
