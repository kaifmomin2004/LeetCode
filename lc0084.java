// Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

import java.util.Stack;

public class lc0084 {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] leftSpan = calculateLeftSpan(heights);
        int[] rightSpan = calculateRightSpan(heights);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (leftSpan[i] + rightSpan[i]);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static int[] calculateLeftSpan(int[] arr) {
        int n = arr.length;
        int[] leftSpan = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

            leftSpan[i] = (st.isEmpty()) ? i + 1 : i - st.peek();
            st.push(i);
        }
        return leftSpan;
    }

    public static int[] calculateRightSpan(int[] arr) {
        int n = arr.length;
        int[] rightSpan = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();

            rightSpan[i] = (st.isEmpty()) ? n - i - 1 : st.peek() - i - 1;
            st.push(i);
        }
        return rightSpan;
    }
}