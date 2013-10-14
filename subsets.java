public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) return ans;
        for (int i = 0; i < (1 << S.length); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            int val = i, index = 0;
            while (val > 0) {
                if ((val & 1) != 0) subset.add(S[index]);
                val >>>= 1;
                index++;
            }
            ans.add(subset);
        }
        return ans;
    }
}
