public class LC1662 {
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"},new String[]{"a", "bc"}));
    }
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String a="";
        String b="";
        for (int i = 0; i <word1.length ; i++) {
            a+=word1[i];
        }
        for (int i = 0; i < word2.length ; i++) {
            b+=word2[i];
        }
        return a.equals(b);
    }
}
