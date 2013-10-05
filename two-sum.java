import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> numIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            Integer need_index = numIndex.get(target - numbers[i]);
            if (need_index != null) {
                int[] ans = {need_index + 1, i + 1};
                return ans;
            }
            numIndex.put(numbers[i], i);
        }
        return null;
    }
}
