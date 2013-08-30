class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        vector<pair<string*, string> > pairs;
        for (int i = 0; i < strs.size(); i++) {
            pairs.push_back(make_pair(&strs[i], strs[i]));
            sort(pairs.back().second.begin(), pairs.back().second.end());
        }
        sort(pairs.begin(), pairs.end(), pair_comparator);
        vector<string> anas;
        int num = pairs.empty() ? 0 : 1;
        for (int i = 1; i < pairs.size(); i++) {
            if (pairs[i].second == pairs[i - 1].second) {
                num++;
            } else {
                if (num > 1) {
                    for (int j = 1; j <= num; j++)
                        anas.push_back(*pairs[i - j].first);
                }
                num = 1;
            }
        }
        if (num > 1) {
            for (int i = 1; i <= num; i++)
                anas.push_back(*(pairs.end() - i)->first);
        }
        return anas;
    }
    
    static bool pair_comparator(const pair<string*, string>& p1,
            const pair<string*, string>& p2) {
        return p1.second < p2.second;
    }
};
