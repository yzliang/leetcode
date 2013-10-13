public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        if (num == null || num.length == 0)
            return new ArrayList<ArrayList<Integer>>();
        ans = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        search(num, 0);
        return new ArrayList<ArrayList<Integer>>(ans);
    }

    private void search(int[] num, int pos) {
        if (pos == num.length) {
            ArrayList<Integer> list = new ArrayList<Integer>(num.length);
            for (int i : num) list.add(i);
            ans.add(list);
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

    private Set<ArrayList<Integer>> ans;
}
