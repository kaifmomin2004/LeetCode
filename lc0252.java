import java.util.*;

/*
LeetCode 252 – Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]  
determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: true

Constraints:
- 0 <= intervals.length <= 10⁴
- intervals[i].length == 2
- 0 <= starti < endi <= 10⁶
*/

public class lc0252 {
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

            boolean result = canAttendMeetings(intervals);
            System.out.println(result);
        }

        sc.close();
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        // TODO: implement logic to check for overlapping intervals

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int i = 0;
        while (++i < intervals.length) {
            if (intervals[i-1][1] >= intervals[i][0])
                return false;
        }
        return true;
    }
}
