class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int> > dis(word1.size() + 1, vector<int>(word2.size() + 1));
        for (int i = 0; i <= word2.size(); i++)
            dis[0][i] = i;
        for (int i = 0; i <= word1.size(); i++)
            dis[i][0] = i;
        for (int i = 1; i <= word1.size(); i++)
            for (int j = 1; j <= word2.size(); j++) {
                // Replace.
                dis[i][j] = dis[i - 1][j - 1] + (word1[i - 1] != word2[j - 1]);
                // Insert.
                if (dis[i][j - 1] + 1 < dis[i][j])
                    dis[i][j] = dis[i][j - 1] + 1;
                // Delete.
                if (dis[i - 1][j] + 1 < dis[i][j])
                    dis[i][j] = dis[i - 1][j] + 1;
            }
        return dis[word1.size()][word2.size()];
    }
};
