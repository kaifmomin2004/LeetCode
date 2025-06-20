import java.util.*;

/*
LeetCode 162 – Find Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given an integer array `nums`, find a peak element, and return its index.  
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that `nums[-1] = nums[n] = -∞`.  
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index 1 (2) or index 5 (6), both are valid.

Constraints:
- 1 <= nums.length <= 1000
- -2³¹ <= nums[i] <= 2³¹ - 1
- nums[i] != nums[i+1] for all valid i
*/

public class lc0162 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int peakIndex = findPeakElement(nums);
            System.out.println(peakIndex);
        }

        sc.close();
    }

    public static int findPeakElement(int[] nums) {
        // TODO: implement binary search to find a peak element
        int s=0, e=nums.length-1;
        while (s<e) {
            int mid=(s+e)/2;
            // if (nums[s]<=nums[mid] && nums[e]<nums[mid]) e--;
            // else if(nums[mid]<=nums[e]) s=mid+1;
            // else if(nums[mid]<=nums[s]) e=mid-1;

            if (nums[mid] > nums[mid + 1]) e = mid;
            else s = mid + 1;
        }
        return e;
    }
}
