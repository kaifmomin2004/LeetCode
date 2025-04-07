// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [3,4]
import java.util.Arrays;

public class lc0034 {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = startIndex(nums, target);
        int end = endIndex(nums, target);
        return new int[] { start, end };
    }

    public static int startIndex(int[] nums, int target) {
        int i = 0, j = nums.length - 1, ans = -1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target) {
                ans = m;
                j = m - 1;
            } else if (target > nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return ans;
    }

    public static int endIndex(int[] nums, int target) {
        int i = 0, j = nums.length - 1, ans = -1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target) {
                ans = m;
                i = m + 1;
            } else if (target > nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return ans;
    }
}