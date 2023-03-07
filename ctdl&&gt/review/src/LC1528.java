import java.util.HashMap;
import java.util.Map;

public class LC1528 {
    public String restoreString(String s, int[] indices) {
        String str="";
        Map<Integer,Character>map=new HashMap<>();
        for (int i = 0; i <indices.length ; i++) {
            map.put(indices[i],s.charAt(i));
        }
        for (int i = 0; i <s.length() ; i++) {
            str+=map.get(i);
        }
        return str;
    }
}
