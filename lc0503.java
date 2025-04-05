// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

// Input: nums = [1,2,1]
// Output: [2,-1,2]
// Explanation: The first 1's next greater number is 2; 
// The number 2 can't find next greater number. 
// The second 1's next greater number needs to search circularly, which is also 2.

import java.util.Arrays;
import java.util.Stack;

public class lc0503 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int curr = nums[i % n];
            while (!st.isEmpty() && nums[st.peek()] < curr) {
                // int prev = st.pop();
                result[st.pop()] = curr;
            }
            if (i < n) {
                result[i] = -1;
                st.push(i);
            }
        }
        return result;
    }
}