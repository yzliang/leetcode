class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        vector<string> text;
        vector<string>::iterator iter1 = words.begin();
        while (iter1 != words.end()) {
            vector<string>::iterator iter2 = iter1 + 1;
            int sum_length = iter1->size();
            while (iter2 != words.end() &&
                    sum_length + (iter2 - iter1) + iter2->size() <= L) {
                sum_length += iter2->size();
                iter2++;
            }
            string line(*iter1);
            if (iter2 == words.end()) {
                // Last line.
                iter1++;
                while (iter1 != words.end()) {
                    line += ' ';
                    line += *iter1;
                    iter1++;
                }
                line.append(L - line.size(), ' ');
            } else if (iter1 + 1 == iter2) {
                // Single word.
                line.append(L - line.size(), ' ');
            } else {
                int num_words = iter2 - iter1;
                int num_space = (L - sum_length) / (num_words - 1);
                int num_extra_space = (L - sum_length) % (num_words - 1);
                for (int i = 1; i < num_words; i++) {
                    line.append(i <= num_extra_space ? num_space + 1 : num_space,
                        ' ');
                    line += *(iter1 + i);
                }
            }
            iter1 = iter2;
            text.push_back(line);
        }
        return text;
    }
};
