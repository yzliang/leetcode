class Solution {
public:
    string addBinary(string a, string b) {
        string ret;
        int carry = 0;
        int common_len = min(a.size(), b.size());
        for (int i = 1; i <= common_len; i++) {
            int sum = (a[a.size() - i] - '0') + (b[b.size() - i] - '0') + carry;
            ret.push_back(sum % 2 + '0');
            carry = sum / 2;
        }
        if (a.size() > common_len) {
            for (int i = a.size() - common_len - 1; i >= 0; i--) {
                int sum = a[i] - '0' + carry;
                ret.push_back(sum % 2 + '0');
                carry = sum / 2;
            }
        }
        if (b.size() > common_len) {
            for (int i = b.size() - common_len - 1; i >= 0; i--) {
                int sum = b[i] - '0' + carry;
                ret.push_back(sum % 2 + '0');
                carry = sum / 2;
            }
        }
        if (carry == 1)
            ret.push_back('1');
        reverse(ret.begin(), ret.end());
        return ret;
    }
};
