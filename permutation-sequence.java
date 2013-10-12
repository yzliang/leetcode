public class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = fact[i - 1] * i;
        boolean[] used = new boolean[n];
        StringBuilder ans = new StringBuilder();
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int order = k / fact[i];
            k = k % fact[i];
            int j = 0;
            while (order > 0 || used[j]) {
                if (!used[j]) order--;
                j++;
            }
            used[j] = true;
            ans.append(j + 1);
        }
        return ans.toString();
    }
}
