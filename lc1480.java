// Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
// Return the running sum of nums.

// Input: nums = [1,2,3,4]
// Output: [1,3,6,10]
// Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

import java.util.Arrays;

public class lc1480 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(runningSum(nums)));
    }

    public static int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = nums[0];

        for (int i = 1; i < result.length; i++)
            result[i] = result[i - 1] + nums[i];
        return result;
    }
}