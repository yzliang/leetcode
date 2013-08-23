import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        if (num.length == 0) return new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            Integer count = numCount.get(num[i]);
            numCount.put(num[i], count == null ? 1 : count + 1);
        }
        Arrays.sort(num);
        int total = 1;
        for (int i = 0; i < num.length; i++) {
            if (num[i] != num[total - 1]) {
                num[total++] = num[i];
            }
        }
        // Enumerate pairs.
        HashMap<Integer, ArrayList<Pair>> numPairs =
            new HashMap<Integer, ArrayList<Pair>>();
        for (int i = 0; i < total; i++) {
            for (int j = i; j < total; j++) {
                ArrayList<Pair> pairs = numPairs.get(num[i] + num[j]);
                if (pairs != null) {
                    pairs.add(new Pair(num[i], num[j]));
                } else {
                    pairs = new ArrayList<Pair>(2);
                    pairs.add(new Pair(num[i], num[j]));
                    numPairs.put(num[i] + num[j], pairs);
                }
            }
        }
        // Match.
        ArrayList<ArrayList<Integer>> quads =
            new ArrayList<ArrayList<Integer>>();
        int[] quad = new int[4];
        for (int i = 0; i < total; i++) {
            for (int j = i; j < total; j++) {
                ArrayList<Pair> pairs = numPairs.get(target - num[i] - num[j]);
                if (pairs == null) continue;
                for (Pair pair : pairs) {
                    // Keep order.
                    if (num[j] > pair.a) continue;
                    // Validate the quad.
                    quad[0] = num[i];
                    quad[1] = num[j];
                    quad[2] = pair.a;
                    quad[3] = pair.b;
                    boolean ok = true;
                    for (int k = 0; k < 4; k++) {
                        int l;
                        for (l = k + 1; l < 4 && quad[l] == quad[k]; l++);
                        if (l - k > 1 && numCount.get(quad[k]) < l - k) {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;
                    ArrayList<Integer> quadList = new ArrayList<Integer>(4);
                    for (int k = 0; k < 4; k++) {
                        quadList.add(quad[k]);
                    }
                    quads.add(quadList);
                }
            }
        }
        return quads;
    }
}
