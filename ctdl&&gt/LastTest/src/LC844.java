import java.util.Stack;

public class LC844 {
    public boolean backspaceCompare(String s, String t) {
        return getCompareString(s).equals(getCompareString(t));
    }

    private Stack<Character> getCompareString(String source) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
//            kí tự hiện tại không phải #->thêm vào stack
            if (currentChar != '#') {
                stack.push(currentChar);
            }
            // ngược lại nếu là #->xóa kí tự trưóc nó khỏi stack
            else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return stack;
//        time,space:O(m+n)->m,n là độ dài 2 chuỗi
    }
}
