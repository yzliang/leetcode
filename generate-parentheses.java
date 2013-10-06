public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<String>();
        char[] parens = new char[n * 2];
        generate(0, n, 0, parens, ans);
        return ans;
    }

    private void generate(int pos, int num_parens, int num_left, char[] parens,
            ArrayList<String> ans) {
        if (num_parens == 0 && num_left == 0) {
            ans.add(String.valueOf(parens));
            return;
        }
        if (num_parens > 0) {
            parens[pos] = '(';
            generate(pos + 1, num_parens - 1, num_left + 1, parens, ans);
        }
        if (num_left > 0) {
            parens[pos] = ')';
            generate(pos + 1, num_parens, num_left - 1, parens, ans);
        }
    }
}
