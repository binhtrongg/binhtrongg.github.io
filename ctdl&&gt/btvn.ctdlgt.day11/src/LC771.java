import java.util.HashSet;
import java.util.Set;

public class LC771 {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character>jw=new HashSet<>();
        for (char c:jewels.toCharArray()) {
            jw.add(c);
        }
        int count=0;
        for (char c:stones.toCharArray()) {
            if (jw.contains(c)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA","aAAbbbb"));
    }
}
