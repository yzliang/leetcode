#include <queue>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>
using namespace std;

class Solution {
public:
  int ladderLength(string start, string end, unordered_set<string>& dict) {
    // Construct word graph.
    dict.insert(start);
    dict.insert(end);
    vector<string> words(dict.begin(), dict.end());
    typedef unordered_map<string, vector<int> > group_type;
    group_type groups;
    for (int i = 0; i < words.size(); i++) {
      for (int pos = 0; pos < words[i].size(); pos++) {
        char old = words[i][pos];
        words[i][pos] = '#';
        group_type::iterator it = groups.find(words[i]);
        if (it == groups.end()) {
          pair<group_type::iterator, bool> p = groups.insert(
              make_pair(words[i], vector<int>()));
          p.first->second.push_back(i);
        } else {
          it->second.push_back(i);
        }
        words[i][pos] = old;
      }
    }
    vector<vector<int> > neighbors(words.size());
    for (group_type::iterator it = groups.begin(); it != groups.end(); it++) {
      vector<int>& group = it->second;
      for (int i = 0; i < group.size(); i++)
        for (int j = i + 1; j < group.size(); j++) {
          neighbors[group[i]].push_back(group[j]);
          neighbors[group[j]].push_back(group[i]);
        }
    }

    // BFS.
    int startIndex, endIndex;
    for (int i = 0; i < words.size(); i++) {
      if (words[i] == start) startIndex = i;
      if (words[i] == end) endIndex = i;
    }
    vector<int> dis(words.size());
    queue<int> q;
    q.push(startIndex);
    dis[startIndex] = 1;
    while (!q.empty() && dis[endIndex] == 0) {
      int head = q.front();
      q.pop();
      for (int i = 0; i < neighbors[head].size(); i++) {
        if (dis[neighbors[head][i]] == 0) {
          dis[neighbors[head][i]] = dis[head] + 1;
          q.push(neighbors[head][i]);
        }
      }
    }
    return dis[endIndex];
  }
};
