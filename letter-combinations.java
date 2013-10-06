public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        ans = new ArrayList<String>();
        generate(digits, 0, new char[digits.length()]);
        return ans;
    }

    private void generate(String digits, int pos, char[] comb) {
        if (pos == digits.length()) {
            ans.add(new String(comb));
            return;
        }
        int digit = digits.charAt(pos) - '0';
        for (int i = 0; i < map[digit].length(); i++) {
            comb[pos] = map[digit].charAt(i);
            generate(digits, pos + 1, comb);
        }
    }

    private ArrayList<String> ans = null;
    private static String[] map = {" ", "", "abc", "def", "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"};
}
