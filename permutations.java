public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ans = new ArrayList<ArrayList<Integer>>();
        if (num ==  null) return ans;
        search(num, 0);
        return ans;
    }

    private void search(int[] num, int pos) {
        if (pos == num.length) {
            ArrayList<Integer> permutation = new ArrayList<Integer>(num.length);
            for (int i : num) permutation.add(i);
            ans.add(permutation);
            return;
        }
        search(num, pos + 1);
        for (int i = pos + 1; i < num.length; i++) {
            swap(num, pos, i);
            search(num, pos + 1);
            swap(num, pos, i);
        }
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private ArrayList<ArrayList<Integer>> ans;
}
