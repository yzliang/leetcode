class Solution {
public:
    string countAndSay(int n) {
        static char buffer[10];
        string s1 = "1";
        string s2;
        for (int i = 1; i < n; i++) {
            s2.clear();
            int j = 0, len = 1;
            while (j < s1.size()) {
                if (j < s1.size() - 1 && s1[j] == s1[j + 1]) {
                    len++;
                } else {
                    itoa(len, buffer);
                    s2.append(buffer);
                    s2.push_back(s1[j]);
                    len = 1;
                }
                j++;
            }
            s1 = s2;
        }
        return s1;
    }
    
    char* itoa(int i, char* str) {
        char* last = str;
        if (i == 0) {
            *last++ = '0';
        } else {
            while (i > 0) {
                *last++ = i % 10 + '0';
                i /= 10;
            }
        }
        *last-- = '\0';
        for (char* l = str; l < last; l++) {
            char c = *l;
            *l = *last;
            *last-- = c;
        }
    }
};
