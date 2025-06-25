/*
LeetCode 40: Combination Sum II

Given a collection of candidate numbers `candidates` and a target number `target`, find all unique combinations in `candidates`
where the candidate numbers sum to `target`.

Each number in `candidates` may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
  [1,1,6],
  [1,2,5],
  [1,7],
  [2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output:
[
  [1,2,2],
  [5]
]

Constraints:
- 1 <= candidates.length <= 100
- 1 <= candidates[i] <= 50
- 1 <= target <= 30
*/

#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> ans;

void combinationSum2Helper(vector<int> &candidates, vector<int> asf, int index, int target)
{
    if (target == 0)
    {
        ans.push_back(asf);
        return;
    }
    for (int i = index; i < candidates.size(); i++)
    {
        if (candidates[i] > target)
            break;
        if (i > index && candidates[i] == candidates[i - 1])
            continue;
        asf.push_back(candidates[i]);
        combinationSum2Helper(candidates, asf, i+1, target-candidates[i]);
        asf.pop_back();
    }
}

vector<vector<int>> combinationSum2(vector<int> &candidates, int target)
{
    // TODO: Implement this method
    sort(candidates.begin(), candidates.end());
    combinationSum2Helper(candidates, vector<int>(), 0, target);
    return ans;
}

int main()
{
    int t;
    cin >> t;

    while (t-- > 0)
    {
        int n, target;
        cin >> n;
        vector<int> candidates(n);
        for (int i = 0; i < n; ++i)
        {
            cin >> candidates[i];
        }
        cin >> target;

        vector<vector<int>> result = combinationSum2(candidates, target);

        for (const auto &comb : result)
        {
            cout << "[";
            for (size_t i = 0; i < comb.size(); ++i)
            {
                cout << comb[i];
                if (i < comb.size() - 1)
                    cout << ",";
            }
            cout << "]\n";
        }
    }

    return 0;
}
