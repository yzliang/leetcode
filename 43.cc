class Solution {
public:
    string multiply(string num1, string num2) {
        reverse(num1.begin(), num1.end());
        reverse(num2.begin(), num2.end());
        string ans(num1.size() + num2.size(), 0);
        for (int i = 0; i < num1.size(); i++)
            for (int j = 0; j < num2.size(); j++) {
                ans[i + j] += (num1[i] - '0') * (num2[j] - '0');
                if (ans[i + j] >= 10) {
                    ans[i + j + 1] += ans[i + j] / 10;
                    ans[i + j] %= 10;
                }
            }
        for (int i = 0; i < ans.size() - 1; i++)
            if (ans[i] >= 10) {
                ans[i + 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        while (ans.size() > 1 && ans[ans.size() - 1] == 0)
            ans.pop_back();
        for (int i = 0; i < ans.size(); i++) ans[i] += '0';
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
