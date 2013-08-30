class Solution {
public:
    // Extremely buggy!
    bool isMatch(const char *s, const char *p) {
        int n = strlen(s), m = strlen(p);
        if (n > 0 && m == 0) return false;
        int left = -1;
        int start_pos = 0;
        for (int i = 0; i < m; i++) {
            if (p[i] != '*') {
                if (left == -1) left = i;
            } else {
                if (left != -1) {
                    // Match and shift the start_pos.
                    int len = i - left;
                    int index = match(s, start_pos, p, left, len);
                    if (index == -1) return false;
                    if (left == 0 && index != 0) return false;
                    start_pos = index + len;
                }
                left = -1;
            }
        }
        if (left != -1) {
            // Last match.
            if (n - (m - left) < start_pos) return false;
            for (int i = left; i < m; i++)
                if (p[i] != '?' && p[i] != s[n - (m - i)]) return false;
            if (left == 0 && n != m) return false;
        }
        return true;
    }
    
    int match(const char* s, int pos1, const char* p, int pos2, int len) {
        while (true) {
            bool equal = true;
            for (int i = 0; i < len; i++) {
                if (s[pos1 + i] == '\0') return -1;
                if (p[pos2 + i] != '?' && s[pos1 + i] != p[pos2 + i]) {
                    equal = false;
                    break;
                }
            }
            if (equal) return pos1;
            pos1++;
        }
    }
};
