public class LC1672 {
    public int maximumWealth(int[][] accounts) {
        int total=0;
        for (int[] e:accounts) {
            int totalInLine=0;
            for (int v:e) {
                totalInLine+=v;
            }
            total=Math.max(total,totalInLine);
        }
        return total;
    }
}
