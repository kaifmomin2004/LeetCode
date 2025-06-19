import java.util.*;

/*
LeetCode 153 – Find Minimum in Rotated Sorted Array

Suppose an array of length n sorted in ascending order is rotated between 1 and n times.  
Given the rotated array `nums` of unique elements, return the minimum element of this array.  
You must write an algorithm that runs in O(log n) time.

Example 1:
Input: nums = [3,4,5,1,2]
Output: 1

Example 2:
Input: nums = [4,5,6,7,0,1,2]
Output: 0

Example 3:
Input: nums = [11,13,15,17]
Output: 11

Constraints:
- n == nums.length
- 1 <= n <= 5000
- -5000 <= nums[i] <= 5000
- All the integers of nums are unique
- nums is guaranteed to be rotated at least once
*/

public class lc0153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int min = findMin(nums);
            System.out.println(min);
        }

        sc.close();
    }

    public static int findMin(int[] nums) {
        // TODO: implement binary search to find minimum in rotated array
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] < nums[e]) e=mid;
            else s=mid+1;
        }
        return nums[s];
    }
}