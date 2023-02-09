public class Print2Darr {
    public static void main(String[] args) {
        int[][]ar={
                {1,2,3},
                {4,5,6}
        };
        prinAr2d(ar,0,0);
    }
    public static void prinAr2d(int[][] arr, int r, int c) {
        if (r == arr.length) {
            return;
        }
        if (c == arr[r].length) {
            System.out.println();
            prinAr2d(arr, r + 1, 0);
            return;
        }
        System.out.print(arr[r][c] + " ");
        prinAr2d(arr, r, c+1);
    }
}
