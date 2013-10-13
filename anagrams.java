public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, Integer> wordCount = new HashMap<String, Integer>();
        String[] keys = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            Integer count = wordCount.get(key);
            wordCount.put(key, count == null ? 1 : count + 1);
            keys[i] = key;
        }
        ArrayList<String> ans = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            if (wordCount.get(keys[i]) > 1)
                ans.add(strs[i]);
        }
        return ans;
    }
}
