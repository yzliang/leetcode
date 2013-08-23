import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        if (L.length == 0) return new ArrayList<Integer>();
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            Integer count = wordCount.get(L[i]);
            wordCount.put(L[i], count == null ? 1 : count + 1);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int len = L[0].length();
        int totalLength = L.length * len;
        for (int i = 0; i + totalLength <= S.length(); i++) {
            HashMap<String, Integer> subCount = new HashMap<String, Integer>();
            boolean match = true;
            for (int j = i; j < i + totalLength; j += len) {
                String word = S.substring(j, j + len);
                Integer totalCount = wordCount.get(word);
                if (totalCount == null) {
                    match = false;
                    break;
                }
                Integer count = subCount.get(word);
                if (count != null && count == totalCount) {
                    match = false;
                    break;
                }
                subCount.put(word, count == null ? 1 : count + 1);
            }
            if (match) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] l = {"fooo","barr","wing","ding","wing"};
        System.out.println(new Solution().findSubstring(s, l));
    }

}
