/*
LeetCode 2040: Kth Smallest Product of Two Sorted Arrays

Given two sorted 0-indexed integer arrays `nums1` and `nums2` as well as an integer `k`, return the k-th smallest product of `nums1[i] * nums2[j]` where `0 <= i < nums1.length` and `0 <= j < nums2.length`.

Example 1:
Input: nums1 = [2,5], nums2 = [3,4], k = 2
Output: 8
Explanation: The products are [6, 8, 10], and the 2nd smallest is 8.

Example 2:
Input: nums1 = [-4,-2,0,3], nums2 = [2,4], k = 6
Output: 0
Explanation: The products are [-8,-4,0,6,8,12, -6, -2], sorted => [-8, -6, -4, -2, 0, 0, 6, 8, 12], and 6th smallest is 0.

Constraints:
- 1 <= nums1.length, nums2.length <= 5 * 10^4
- -10^5 <= nums1[i], nums2[j] <= 10^5
- nums1 and nums2 are sorted in non-decreasing order
- 1 <= k <= nums1.length * nums2.length
*/

#include <bits/stdc++.h>
using namespace std;

long long countProducts(vector<int> &nums1, vector<int> &nums2, long long target)
{
    long long count = 0;
    for (int num1 : nums1)
    {
        if (num1 == 0)
        {
            if (target >= 0)
                count += nums2.size();
            continue;
        }

        int low = 0, high = nums2.size();
        while (low < high)
        {
            int mid = (low + high) / 2;
            long long prod = 1LL * num1 * nums2[mid];
            if (prod <= target)
            {
                if (num1 > 0)
                    low = mid + 1;
                else
                    high = mid;
            }
            else
            {
                if (num1 > 0)
                    high = mid;
                else
                    low = mid + 1;
            }
        }

        count += (num1 > 0) ? low : (nums2.size() - low);
    }
    return count;
}

long long kthSmallestProduct(vector<int> &nums1, vector<int> &nums2, long long k)
{
    long long left = -1e10, right = 1e10;
    while (left < right)
    {
        long long mid = left + (right - left) / 2;
        if (countProducts(nums1, nums2, mid) < k)
            left = mid + 1;
        else
            right = mid;
    }
    return left;
}

int main()
{
    int t;
    cin >> t;

    while (t-- > 0)
    {
        int n, m;
        cin >> n;
        vector<int> nums1(n);
        for (int i = 0; i < n; ++i)
        {
            cin >> nums1[i];
        }

        cin >> m;
        vector<int> nums2(m);
        for (int i = 0; i < m; ++i)
        {
            cin >> nums2[i];
        }

        long long k;
        cin >> k;

        long long result = kthSmallestProduct(nums1, nums2, k);
        cout << result << '\n';
    }

    return 0;
}

// Solution link:
// https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays/solutions/6881305/beginner-freindly-java-c-python-js/?envType=daily-question&envId=2025-06-25
