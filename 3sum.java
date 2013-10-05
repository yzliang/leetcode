import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> triplets =
            new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) return triplets;
        // Count.
        HashMap<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            Integer count = numCount.get(num[i]);
            numCount.put(num[i], count == null ? 1 : count + 1);
        }
        // Sort and unique.
        Arrays.sort(num);
        int total = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] != num[total - 1]) {
                num[total++] = num[i];
            }
        }
        // Find triplets.
        for (int i = 0; i < total; i++) {
            for (int j = i; j < total; j++) {
                int num1 = num[i], num2 = num[j], num3 = 0 - num1 - num2;
                if (num3 < num2) continue;
                if (!numCount.containsKey(num3)) continue;
                // Validatation.
                if (num1 == num3 && numCount.get(num1) < 3)
                    continue;
                if (num1 == num2 && numCount.get(num1) < 2 ||
                        num2 == num3 && numCount.get(num2) < 2)
                    continue;
                ArrayList<Integer> triplet = new ArrayList<Integer>(3);
                Collections.addAll(triplet, num1, num2, num3);
                triplets.add(triplet);
            }
        }
        return triplets;
    }
}
