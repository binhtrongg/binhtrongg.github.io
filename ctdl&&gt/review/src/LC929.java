import java.util.HashSet;
import java.util.Set;

public class LC929 {
    public int numUniqueEmails(String[] emails) {
        Set<String>hs=new HashSet<>();
        for (String email:emails) {
            String[] mailParts=email.split("@");
            String userName=mailParts[0].replace(".","");
            if (userName.contains("+")){
                userName=userName.substring(0,userName.indexOf("+"));
            }
            hs.add(userName+"@"+mailParts[1]);
        }
        return hs.size();
    }
}
