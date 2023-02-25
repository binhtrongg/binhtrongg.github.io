import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ele : s.toCharArray()) {
            if (ele == '(' || ele == '[' || ele == '{') {
                stack.push(ele);
            }
            else if (stack.isEmpty()
                    ||ele==')'&&stack.pop()!='('
                    ||ele==']'&&stack.pop()!='['
                    ||ele=='}'&&stack.pop()!='{'){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
