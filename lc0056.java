// // Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

// // Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// // Output: [[1,6],[8,10],[15,18]]
// // Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

// import java.util.Arrays;

// public class lc0056 {
//     public static void main(String[] args) {
//         int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
//         System.out.println(Arrays.deepToString(merge(intervals)));
//     }

//     public static int[][] merge(int[][] intervals) {
//         if (intervals == null || intervals.length == 0) {
//             return new int[0][];
//         }

//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

//         int idx = 0;
//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[i][0] <= intervals[idx][1]) {
//                 intervals[idx][1] = Math.max(intervals[idx][1], intervals[i][1]);
//             } else {
//                 idx++;
//                 intervals[idx] = intervals[i];
//             }
//         }
//         return Arrays.copyOfRange(intervals, 0, idx + 1);
//     }
// }

import java.util.*;

/*
LeetCode 56 – Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,  
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]  
Output: [[1,6],[8,10],[15,18]]

Example 2:
Input: intervals = [[1,4],[4,5]]  
Output: [[1,5]]

Constraints:
- 1 <= intervals.length <= 10⁴
- intervals[i].length == 2
- 0 <= starti <= endi <= 10⁴
*/

public class lc0056 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // number of intervals
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            int[][] result = merge(intervals);

            for (int[] interval : result) {
                System.out.print("[" + interval[0] + "," + interval[1] + "] ");
            }
            System.out.println();
        }

        sc.close();
    }

    public static int[][] merge(int[][] intervals) {
        // TODO: implement merging of overlapping intervals
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int i = 0;
        int j = 0;
        while (++j < intervals.length) {
            if (intervals[i][1] >= intervals[j][0] && intervals[j][1] >= intervals[i][0]) {
                intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            } else {
                i++;
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
            }
        }
        return Arrays.copyOf(intervals, i + 1);
    }
}
