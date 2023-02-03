public class LC344 {
    public static void main(String[] args) {
        System.out.println((int)('a'+'b'));
    }
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length; i++) {
            char val=s[s.length-1-i];
            s[s.length-1-i]=s[i];
            s[i]=val;
        }
    }
}
