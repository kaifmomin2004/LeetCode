/*
LeetCode 271: Encode and Decode Strings

Design an algorithm to encode a list of strings to a single string. The encoded string is then sent over the network 
and is decoded back to the original list of strings.

Implement the `encode` and `decode` methods:

- `string encode(vector<string>& strs)`: Encodes a list of strings to a single string.
- `vector<string> decode(string s)`: Decodes a single string to a list of strings.

Example 1:
Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]

Explanation:
One possible encoding scheme is to encode each string with its length followed by a special delimiter and then the string:
E.g., "4#lint4#code4#love3#you"

Constraints:
- 0 <= strs.length < 100
- 0 <= strs[i].length < 200
- `strs[i]` contains any possible characters except the delimiter used in your encoding
*/

#include <bits/stdc++.h>
using namespace std;

string encode(vector<string>& strs) {
    string encoded_string = "";
        for (const string& s : strs) {
            encoded_string += to_string(s.length()) + "#" + s;
        }
        return encoded_string;
}

vector<string> decode(string s) {
    vector<string> decoded_strings;
        int i = 0;

        while (i < s.length()) {
            int j = i;
            while (s[j] != '#') {
                j++;
            }
            
            int length = stoi(s.substr(i, j - i));
            
            string str = s.substr(j + 1, length);
            decoded_strings.push_back(str);
            
            i = j + 1 + length;
        }
        
        return decoded_strings;
}

int main() {
    int t;
    cin >> t;

    while (t-- > 0) {
        int n;
        cin >> n;
        cin.ignore();
        vector<string> strs(n);
        for (int i = 0; i < n; ++i) {
            getline(cin, strs[i]);
        }

        string encoded = encode(strs);
        vector<string> decoded = decode(encoded);

        for (const string& s : decoded) {
            cout << s << '\n';
        }
    }

    return 0;
}
