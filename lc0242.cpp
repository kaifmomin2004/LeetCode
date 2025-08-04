/*
LeetCode 242: Valid Anagram

Given two strings `s` and `t`, return true if `t` is an anagram of `s`, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
- 1 <= s.length, t.length <= 5 * 10^4
- `s` and `t` consist of lowercase English letters
*/

#include <bits/stdc++.h>
using namespace std;

bool isAnagram(string s, string t)
{
    if (s.length() != t.length())
        return false;

    vector<int> counts(26, 0);

    for (char c : s)
        counts[c - 'a']++;

    for (char c : t)
    {
        counts[c - 'a']--;
        if (counts[c - 'a'] < 0)
            return false;
    }

    return true;
}

int main()
{
    int t;
    cin >> t;
    cin.ignore(); // consume newline after integer

    while (t-- > 0)
    {
        string s1, s2;
        getline(cin, s1);
        getline(cin, s2);

        bool result = isAnagram(s1, s2);
        cout << (result ? "true" : "false") << '\n';
    }

    return 0;
}
