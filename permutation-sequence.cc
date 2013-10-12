class Solution {
public:
    string getPermutation(int n, int k) {
        string result;
        vector<bool> used(n);
        vector<int> fact(n);
        fact[0] = 1;
        for (int i = 1; i < n; i++)
            fact[i] = fact[i - 1] * i;
        k--;
        for (int i = n - 1; i >= 0; i--) {
            int ord = k / fact[i];
            k %= fact[i];
            for (int j = 0; j < n; j++) {
                if (used[j]) continue;
                if (ord == 0) {
                    used[j] = true;
                    result.push_back(j + '1');
                    break;
                }
                ord--;
            }
        }
        return result;
    }
};
