import java.util.*;

/*
LeetCode 435 – Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi],  
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: Remove [1,3] then the rest of the intervals do not overlap.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0

Constraints:
- 1 <= intervals.length <= 10⁴
- intervals[i].length == 2
- -5 * 10⁴ <= starti < endi <= 5 * 10⁴
*/

public class lc0435 {
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

            int result = eraseOverlapIntervals(intervals);
            System.out.println(result);
        }

        sc.close();
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        // TODO: implement logic to remove minimum number of overlapping intervals
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int end=intervals[0][1];
        int count=0;
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0]<end) count++;
            else end=intervals[i][1];

        return count;
    }
}
