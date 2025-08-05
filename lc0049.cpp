/*
LeetCode 49: Group Anagrams

Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
- 1 <= strs.length <= 10^4
- 0 <= strs[i].length <= 100
- strs[i] consists of lowercase English letters
*/

#include <bits/stdc++.h>
using namespace std;

vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagramGroups;

        for (const string& s : strs) {
            string key = s;
            
            sort(key.begin(), key.end());
            
            anagramGroups[key].push_back(s);
        }

        vector<vector<string>> result;
        
        for (const auto& pair : anagramGroups)
            result.push_back(pair.second);

        return result;
}

int main() {
    int t;
    cin >> t;

    while (t-- > 0) {
        int n;
        cin >> n;
        vector<string> strs(n);
        for (int i = 0; i < n; ++i) {
            cin >> strs[i];
        }

        vector<vector<string>> result = groupAnagrams(strs);
        for (const auto& group : result) {
            for (size_t i = 0; i < group.size(); ++i) {
                cout << group[i];
                if (i < group.size() - 1) cout << " ";
            }
            cout << '\n';
        }
        cout << endl;
    }

    return 0;
}
