import java.util.Arrays;

public class LC1859 {
    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
    public static String sortSentence(String s) {
        String[] strings=s.split(" ");
        for (int i = 0; i <strings.length-1 ; i++) {
            for (int j = 0; j <strings.length-i-1 ; j++) {
                if (strings[j].charAt(strings[j].length()-1)>strings[j+1].charAt(strings[j+1].length()-1)) {
                    swap(strings, j, j + 1);
                }
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <strings.length ; i++) {
            stringBuilder.append(strings[i].substring(0,strings[i].length()-1)).append(" ");
        }
        return stringBuilder.toString().trim();
    }
    private static void swap(String[] arr,int i,int j){
        String tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
