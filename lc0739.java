// Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

// Input: temperatures = [73,74,75,71,69,72,76,73]
// Output: [1,1,4,2,1,1,0,0]

import java.util.Arrays;
import java.util.Stack;

public class lc0739 {
    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures2(temperatures)));
    }

    public static int[] dailyTemperatures2(int[] temps) {
        int[] warmerTemps = new int[temps.length];
        for (int i = 0; i < temps.length; i++) {
            for (int j = i; j < temps.length; j++)
                if (temps[j] > temps[i]) {
                    warmerTemps[i] = j - i;
                    break;
                }
        }
        return warmerTemps;
    }

    public static int[] dailyTemperatures(int[] temps) {
        int[] warmerTemps = new int[temps.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < temps.length; i++) {
            while (!st.isEmpty() && temps[st.peek()] < temps[i]) {
                int prevDay = st.pop();
                warmerTemps[prevDay] = i - prevDay;
            }
            st.push(i);
        }
        return warmerTemps;
    }

    // time complexity: O(n^2)
    // space complexity: O(n)
}
