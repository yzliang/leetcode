import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            index.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int other = target - numbers[i];
            if (index.containsKey(other)) {
                int[] answer = {i + 1, index.get(other) + 1};
                if (answer[1] < answer[0]) {
                    int temp = answer[0];
                    answer[0] = answer[1];
                    answer[1] = temp;
                }
                return answer;
            }
        }
        return null;
    }
}
