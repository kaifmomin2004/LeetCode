/*
LeetCode 1539: Kth Missing Positive Number

Given an array `arr` of positive integers sorted in a strictly increasing order, and an integer `k`, return the kth positive integer that is missing from this array.

Example 1:
Input: arr = [2,3,4,7,11], k = 5
Output: 9

Example 2:
Input: arr = [1,2,3,4], k = 2
Output: 6

Constraints:
- 1 <= arr.length <= 1000
- 1 <= arr[i] <= 1000
- 1 <= k <= 1000
*/

#include <bits/stdc++.h>
using namespace std;

int findKthPositive(vector<int> &arr, int k)
{
    // TODO: Implement this method
    if (arr.size() == 1)
        if (arr[0] < k)
            return k + 1;
        else
            return k;

    int s = 0, e = arr.size() - 1;
    while (s <= e)
    {
        int m = s + (e - s) / 2;
        if (arr[m] - m - 1 < k)
            s = m + 1;
        else
            e = m - 1;
    }

    if(s==arr.size()) {
        s--;
        k++;
    }

    int t = arr[s];
    k = k - (t - s);

    cout << s << " " << t << " " << k << "    ";

    return t + k;
}

int main()
{
    int t;
    cin >> t;

    cout << endl;
    while (t-- > 0)
    {
        int n, k;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; ++i)
        {
            cin >> arr[i];
        }
        cin >> k;

        int result = findKthPositive(arr, k);
        cout << result << '\n';
    }

    return 0;
}
