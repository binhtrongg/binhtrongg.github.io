import java.util.Stack;

public class MinStack {
    private static Stack<Integer> stack;
    private  static Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()||val<minStack.peek()){
            minStack.push(val);
        }
    }

    public static void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public static int top() {
        return stack.peek();
    }

    public static int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        stack.push(5);
        System.out.println(stack);
    }
}
