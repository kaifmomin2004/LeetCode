import java.util.*;

/*
LeetCode 35 – Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found.  
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
- 1 <= nums.length <= 10^4
- -10^4 <= nums[i], target <= 10^4
- nums is sorted in ascending order with no duplicates.
*/

public class lc0035 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
        int index = searchInsert(nums, target);
        System.out.println(index);

        sc.close();
    }

    public static int searchInsert(int[] nums, int target) {
        // TODO: implement binary search logic
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] <= target)
                s = mid + 1;
            else
                e = mid - 1;
        }
        return s;
    }
}