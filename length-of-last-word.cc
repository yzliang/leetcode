class Solution {
public:
    int lengthOfLastWord(const char *s) {
        const char* start = NULL;
        int len = 0;
        while (*s) {
            if (isspace(*s)) {
                if (start) {
                    len = s - start;
                    start = NULL;
                }
            } else {
                if (!start) {
                    start = s;
                }
            }
            s++;
        }
        if (start) len = s - start;
        return len;
    }
};
