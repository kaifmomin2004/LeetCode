import java.util.*;

/*
LeetCode 33 – Search in Rotated Sorted Array

There is an integer array `nums` sorted in ascending order (with distinct values), which is rotated at an unknown pivot index `k` (0 <= k < nums.length) such that the resulting array is:
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]

Given the array `nums` after the rotation and an integer `target`, return the index of `target` if it is in `nums`, or -1 if it is not in `nums`.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0  
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3  
Output: -1

Example 3:
Input: nums = [1], target = 0  
Output: -1

Constraints:
- 1 <= nums.length <= 5000
- -10^4 <= nums[i], target <= 10^4
- All values of nums are unique
- nums is guaranteed to be rotated at some pivot
*/

public class lc0033 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Read array size
            int n = sc.nextInt();
            int[] nums = new int[n];

            // Read array elements
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            // Read target
            int target = sc.nextInt();

            // Call the method and print result
            int index = search(nums, target);
            System.out.println(index);
        }

        sc.close();
    }

    public static int search(int[] nums, int target) {
        // TODO: implement binary search for rotated sorted array
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target) return mid;
            if (nums[s] <= nums[mid]) {
                if (nums[s] <= target && target < nums[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            } else if (nums[mid] <= nums[e]) {
                if (nums[mid] < target && target <= nums[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
        }
        return -1;
    }
}
