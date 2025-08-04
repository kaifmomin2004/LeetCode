/*
LeetCode 217: Contains Duplicate

Given an integer array `nums`, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:
- 1 <= nums.length <= 10^5
- -10^9 <= nums[i] <= 10^9
*/

#include <bits/stdc++.h>
using namespace std;

bool containsDuplicate(vector<int> &nums)
{
    map<int, int> seenNumbers;

    for (int num : nums)
    {
        if (seenNumbers.find(num) != seenNumbers.end())
            return true;

        seenNumbers[num] = 1;
    }

    return false;
}

int main()
{
    int t;
    cin >> t;

    while (t-- > 0)
    {
        int n;
        cin >> n;
        vector<int> nums(n);
        for (int i = 0; i < n; ++i)
        {
            cin >> nums[i];
        }

        bool result = containsDuplicate(nums);
        cout << (result ? "true" : "false") << '\n';
    }

    return 0;
}
