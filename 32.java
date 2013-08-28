import java.util.Stack;

public class Solution {
    static class Position {
        int pos;
        int val;
        
        Position(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }
    
    public int longestValidParentheses(String s) {
        int ans = 0;
        int val = 0;
        Stack<Position> positions = new Stack<Position>();
        positions.push(new Position(-1, 0));
        for (int i = 0; i < s.length(); i++) {
            val += s.charAt(i) == '(' ? 1 : -1;
            while (!positions.empty() && positions.peek().val > val) {
                positions.pop();
            }
            if (!positions.empty() && positions.peek().val == val) {
                int lastPos = positions.peek().pos;
                if (i - lastPos > ans) {
                    ans = i - lastPos;
                }
            } else {
                positions.push(new Position(i, val));
            }
        }
        return ans;
    }
}
