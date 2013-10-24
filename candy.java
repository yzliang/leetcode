public class Solution {

    private static class Child {
        int id;
        int rating;

        public Child(int i, int r) {
            id = i;
            rating = r;
        }
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        Child[] children = new Child[n];
        for (int i = 0; i < n; i++)
            children[i] = new Child(i, ratings[i]);
        // Sort the children (0, 1, ..., n - 1) by increasing ratings.
        Arrays.sort(children, new Comparator<Child>() {
            public int compare(Child c1, Child c2) {
                return c1.rating - c2.rating;
            }
        });
        int ans = 0;
        int[] numCandy = new int[n];
        for (int i = 0; i < n; i++) {
            int id = children[i].id;
            numCandy[id] = 1;
            if (id > 0 && ratings[id - 1] < ratings[id])
                numCandy[id] = Math.max(numCandy[id - 1] + 1, numCandy[id]);
            if (id < n - 1 && ratings[id + 1] < ratings[id])
                numCandy[id] = Math.max(numCandy[id + 1] + 1, numCandy[id]);
            ans += numCandy[id];
        }
        return ans;
    }
}
