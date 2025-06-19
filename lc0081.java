import java.util.*;

/*
LeetCode 81 – Search in Rotated Sorted Array II

There is an integer array `nums` sorted in non-decreasing order (not necessarily with distinct values) and rotated at an unknown pivot index `k` such that the array becomes:
[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]].

Given the array `nums` after rotation and an integer `target`, return true if target is in `nums`, or false if it is not.

You must decrease the overall runtime complexity as much as possible.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0  
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3  
Output: false

Constraints:
- 1 <= nums.length <= 5000
- -10^4 <= nums[i], target <= 10^4
*/

public class lc0081 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int target = sc.nextInt();

            boolean found = search(nums, target);
            System.out.println(found);
        }

        sc.close();
    }

    public static boolean search(int[] nums, int target) {
        // TODO: implement binary search for rotated array with duplicates
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] == target || nums[s]==target) return true;
            if (nums[s] < nums[mid]) {
                if (nums[s] <= target && target < nums[mid])
                    e = mid - 1;
                else
                    s = mid + 1;
            }else if (nums[mid] < nums[e]) {
                if (nums[mid] <= target && target <= nums[e])
                    s = mid + 1;
                else
                    e = mid - 1;
            }
            else s++;
        }
        return false;
    }
}
