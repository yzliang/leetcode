import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
                int len = stack.isEmpty() ? i + 1 : i - stack.peek();
                if (len > ans) ans = len;
            } else {
                stack.push(i);
            }
        }
        return ans;
    }
}
