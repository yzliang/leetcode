class Solution {
public:
    bool isNumber(const char *s) {
        const char* e_ptr = strchr(s, 'e');
        if (!e_ptr)
            e_ptr = strchr(s, 'E');
        if (e_ptr) {
            if (!check_base(s)) return false;
            if (!check_exp(e_ptr + 1)) return false;
        } else {
            if (!check_base(s)) return false;
        }
        return true;
    }
    
    bool check_base(const char* s) {
        // Trim left and remove leading sign.
        while (isspace(*s)) s++;
        if (*s == '-') s++;
        // Scan rest.
        bool has_dot = false;
        bool has_digit = false;
        while (*s && *s != 'e' && *s != 'E' && !isspace(*s)) {
            if (*s == '-') {
                return false;
            } else if (*s == '.') {
                if (has_dot) return false;
                has_dot = true;
            } else if (isdigit(s)) {
                has_digit = true;
            } else {
                return false;
            }
            s++;
        }
        while (isspace(*s)) s++;
        if (*s && *s != 'e' && *s != 'E') return false;
        return has_digit;
    }
    
    bool check_exp(const char* s) {
        if (*s == '-') s++;
        while (isdigit(*s)) s++;
        while (isspace(*s)) s++;
        return *s == '\0';
    }
};
