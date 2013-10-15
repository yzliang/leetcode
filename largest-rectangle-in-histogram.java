public class Solution {

    private static class Bar {
        int height;
        int index;

        public Bar(int h, int i) {
            height = h;
            index = i;
        }
    }

    public int largestRectangleArea(int[] height) {
        int ans = 0;
        Stack<Bar> stack = new Stack<Bar>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && stack.peek().height > height[i]) {
                Bar top = stack.pop();
                int left = stack.empty() ? 0 : stack.peek().index + 1;
                ans = Math.max(ans, (i - left) * top.height);
            }
            stack.push(new Bar(height[i], i));
        }
        while (!stack.empty()) {
            Bar top = stack.pop();
            int left = stack.empty() ? 0 : stack.peek().index + 1;
            ans = Math.max((height.length - left) * top.height, ans);
        }
        return ans;
    }
}
