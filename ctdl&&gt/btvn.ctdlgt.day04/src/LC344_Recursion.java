public class LC344_Recursion {
    public static void main(String[] args) {
        char[]chars={'h','e','l','l','o'};
        reverseString(chars,0,chars.length-1);
        System.out.println(chars);
    }
    public static void reverseString(char[] s,int start,int end) {
        if (start>=end){
            return;
        }
        char temp=s[start];
        s[start]=s[end];
        s[end]=temp;
        reverseString(s,start+1,end-1);
    }
}
