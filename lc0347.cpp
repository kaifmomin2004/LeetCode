/*
LeetCode 347: Top K Frequent Elements

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.
You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:
- 1 <= nums.length <= 10^5
- -10^4 <= nums[i] <= 10^4
- k is in the range [1, the number of unique elements in nums]

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

#include <bits/stdc++.h>
using namespace std;

vector<int> topKFrequent(vector<int> &nums, int k)
{
    unordered_map<int, int> freqMap;
    for (int num : nums)
    {
        freqMap[num]++;
    }

    std::priority_queue<std::pair<int, int>, std::vector<std::pair<int, int>>, std::greater<std::pair<int, int>>> minHeap;

    for (const auto &pair : freqMap)
    {
        int num = pair.first;  
        int freq = pair.second; 
        minHeap.push({freq, num});
        if (minHeap.size() > k)
        {
            minHeap.pop(); 
        }
    }

    std::vector<int> result;
    while (!minHeap.empty())
    {
        result.push_back(minHeap.top().second);
        minHeap.pop();
    }

    return result;
}

int main()
{
    int t;
    cin >> t;

    while (t-- > 0)
    {
        int n, k;
        cin >> n;
        vector<int> nums(n);
        for (int i = 0; i < n; ++i)
        {
            cin >> nums[i];
        }
        cin >> k;

        vector<int> result = topKFrequent(nums, k);
        for (int i = 0; i < result.size(); ++i)
        {
            cout << result[i];
            if (i < result.size() - 1)
                cout << " ";
        }
        cout << '\n';
    }

    return 0;
}
