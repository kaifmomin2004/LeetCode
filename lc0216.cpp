/*
LeetCode 216: Combination Sum III

Find all valid combinations of `k` numbers that sum up to `n` such that the following conditions are true:

- Only numbers 1 through 9 are used.
- Each number is used **at most once**.

Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]

Example 3:
Input: k = 4, n = 1
Output: []

Constraints:
- 2 <= k <= 9
- 1 <= n <= 60
*/

#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> ans;

void combinationSum3Helper(int k, vector<int> asf, int idx, int target){
    if(k==0 && target==0){
        ans.push_back(asf);
        return;
    }

    if(target<0 || k<=0) return;

    for (int i = idx; i <= 9; i++)
    {
        if (i>target) break;
        asf.push_back(i);
        combinationSum3Helper(k-1, asf, i+1, target-i);    
        asf.pop_back();
    }
    
}

vector<vector<int>> combinationSum3(int k, int n) {
    // TODO: Implement this method
    combinationSum3Helper(k, vector<int>(), 1, n);

    return ans;
}

int main() {
    int t;
    cin >> t;

    while (t-- > 0) {
        int k, n;
        cin >> k >> n;

        vector<vector<int>> result = combinationSum3(k, n);

        for (const auto& comb : result) {
            for (size_t i = 0; i < comb.size(); ++i) {
                cout << comb[i];
                if (i < comb.size() - 1) cout << " ";
            }
            cout << '\n';
        }
        cout << '\n';
    }

    return 0;
}
