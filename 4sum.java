import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution {

    static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static class Quad implements Comparable<Quad> {
        int a, b, c, d;
        Quad(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }

        public int compareTo(Quad that) {
            if (this.a != that.a) return this.a - that.a;
            if (this.b != that.b) return this.b - that.b;
            if (this.c != that.c) return this.c - that.c;
            if (this.d != that.d) return this.d - that.d;
            return 0;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        if (num.length == 0) return new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        // Enumerate pairs of indicies.
        HashMap<Integer, ArrayList<Pair>> numPairs =
            new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                ArrayList<Pair> pairs = numPairs.get(num[i] + num[j]);
                if (pairs != null) {
                    pairs.add(new Pair(i, j));
                } else {
                    pairs = new ArrayList<Pair>(2);
                    pairs.add(new Pair(i, j));
                    numPairs.put(num[i] + num[j], pairs);
                }
            }
        }
        // Match.
        TreeSet<Quad> quads = new TreeSet<Quad>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                ArrayList<Pair> pairs = numPairs.get(target - num[i] - num[j]);
                if (pairs == null) continue;
                for (Pair pair : pairs) {
                    // Keep order.
                    if (j >= pair.a) continue;
                    quads.add(new Quad(num[i], num[j], num[pair.a],
                                num[pair.b]));
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (Quad quad : quads) {
            ArrayList<Integer> quadList = new ArrayList<Integer>(4);
            Collections.addAll(quadList, quad.a, quad.b, quad.c, quad.d);
            ans.add(quadList);
        }
        return ans;
    }

    public static void main(String args[]) {
        int[] num = {1, 0, -1, 0, -2, 2};
        new Solution().fourSum(num, 0);
    }
}
