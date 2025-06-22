import java.util.*;

/**
 * LeetCode 57 - Insert Interval
 *
 * You are given an array of non-overlapping intervals where intervals[i] =
 * [starti, endi]
 * represent the start and the end of the ith interval and intervals is sorted
 * in ascending
 * order by starti. You are also given an interval newInterval = [start, end]
 * that represents
 * the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in
 * ascending order by
 * starti and intervals still does not have any overlapping intervals (merge
 * overlapping intervals
 * if necessary).
 *
 * Return intervals after the insertion.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 *
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 *
 * Constraints:
 * - 0 <= intervals.length <= 10^4
 * - intervals[i].length == 2
 * - 0 <= starti <= endi <= 10^5
 * - intervals is sorted by starti in ascending order.
 * - newInterval.length == 2
 * - 0 <= start <= end <= 10^5
 */

public class lc0057 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        // TODO: Implement the insert interval logic
        List<int[]> result = new ArrayList<>();

        int i = 0, n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt(); // number of existing intervals
            int[][] intervals = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            int[] newInterval = new int[2];
            newInterval[0] = sc.nextInt();
            newInterval[1] = sc.nextInt();

            int[][] result = insert(intervals, newInterval);
            for (int[] interval : result) {
                System.out.print("[" + interval[0] + "," + interval[1] + "] ");
            }
            System.out.println();
        }

        sc.close();
    }
}