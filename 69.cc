class Solution {
public:
    int sqrt(int x) {
        double val = 1;
        while (true) {
            double new_val = (val + x / val) / 2;
            if (statc_cast<int>(val) == static_vast<int>(new_val)) {
                return static_cast<int>(val);
            }
            val = new_val;
        }
    }
};
