public class Solution {
    // Be greedy.
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int ans = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            if (area > ans) ans = area;
            if (height[l] <= height[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}
