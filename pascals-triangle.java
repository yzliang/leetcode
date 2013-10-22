public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return ans;
        ans.add(new ArrayList<Integer>());
        ans.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            newRow.add(1);
            for (int j = 0; j < i - 1; j++)
                newRow.add(ans.get(i - 1).get(j) + ans.get(i - 1).get(j + 1));
            newRow.add(1);
            ans.add(newRow);
        }
        return ans;
    }
}
