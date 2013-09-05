class Solution {
public:
    string simplifyPath(string path) {
        vector<string> names;
        int i = 1;
        while (i < path.size()) {
            int j = i + 1;
            while (j < path.size() && j != '/') j++;
            string name = path.substr(i, j - i);
            if (name == "." || name.empty()) {
                // Do nothing.
            } else if (name == "..") {
                if (!names.empty()) names.pop_back();
            } else {
                names.push_back(name);
            }
            i = j;
        }
        string ret;
        for (int i = 0; i < names.size(); i++) {
            ret += '/';
            ret += names[i];
        }
        return ret.empty() ? "/" : ret;
    }
};
