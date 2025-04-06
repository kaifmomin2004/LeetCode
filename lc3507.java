// Given an array nums, you can perform the following operation any number of times:
// Select the adjacent pair with the minimum sum in nums. If multiple such pairs exist, choose the leftmost one.
// Replace the pair with their sum.
// Return the minimum number of operations needed to make the array non-decreasing.
// An array is said to be non-decreasing if each element is greater than or equal to its previous element (if it exists).

// Input: nums = [5,2,3,1]

// Output: 2

// Explanation:

// The pair (3,1) has the minimum sum of 4. After replacement, nums = [5,2,4].
// The pair (2,4) has the minimum sum of 6. After replacement, nums = [5,6].
// The array nums became non-decreasing in two operations.

public class lc3507 {
    public static void main(String[] args) {
        int[] nums = { 5, 2, 3, 1 };
        System.out.println(minimumPairRemoval(nums));
    }

    public static int minimumPairRemoval(int[] nums) {
        int count = 0;
        int size = nums.length;
        while (!isSorted(nums, size)) {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < size - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            nums[idx] += nums[idx + 1];
            for (int i = idx + 1; i < size - 1; i++) {
                nums[i] = nums[i + 1];
            }
            size--;
            count++;
        }
        return count;
    }

    public static boolean isSorted(int[] nums, int size) {
        for (int i = 1; i < size; i++)
            if (nums[i] < nums[i - 1])
                return false;
        return true;
    }
}