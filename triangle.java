public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] minSum = new int[triangle.size()];
        minSum[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            ArrayList<Integer> row = triangle.get(i);
            minSum[i] = minSum[i - 1] + row.get(i);
            for (int j = i - 1; j > 0; j--)
                minSum[j] = Math.min(minSum[j], minSum[j - 1]) + row.get(j);
            minSum[0] += row.get(0);
        }
        int ans = minSum[0];
        for (int i = 1; i < minSum.length; i++)
            if (minSum[i] < ans) ans = minSum[i];
        return ans;
    }
}
