public class Solution {
    private static class Element {
        int value;
        int times;
        public Element(int value, int times) {
            this.value = value;
            this.times = times;
        }
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<Element> elements = new ArrayList<Element>();
        int i = 0;
        while (i < num.length) {
            int j = i + 1;
            while (j < num.length && num[j] == num[i]) j++;
            elements.add(new Element(num[i], j - i));
            i = j;
        }
        ans = new ArrayList<ArrayList<Integer>>();
        subset = new ArrayList<Element>();
        search(elements, 0);
        return ans;
    }

    private void search(ArrayList<Element> elements, int pos) {
        if (pos == elements.size()) {
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for (Element e : subset) {
                for (int i = 0; i < e.times; i++)
                    nums.add(e.value);
            }
            ans.add(nums);
            return;
        }
        for (int i = 1; i <= elements.get(pos).times; i++) {
            subset.add(new Element(elements.get(pos).value, i));
            search(elements, pos + 1);
            subset.remove(subset.size() - 1);
        }
        search(elements, pos + 1);
    }

    private ArrayList<Element> subset;
    private ArrayList<ArrayList<Integer>> ans;
}
