import java.util.*;

/*
LeetCode 253 – Meeting Rooms II

Given an array of meeting time intervals `intervals` where intervals[i] = [starti, endi],  
return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:
- 1 <= intervals.length <= 10⁴
- 0 <= starti < endi <= 10⁶
*/

public class lc0253 {
    static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                intervals.add(new Interval(start, end));
            }

            int result = minMeetingRooms(intervals);
            System.out.println(result);
        }

        sc.close();
    }

    public static int minMeetingRooms(List<Interval> intervals) {
        // TODO: implement logic to calculate minimum number of meeting rooms

        int n = intervals.size();
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int startInd = 0;
        int endInd = 0;
        int minDay = 0;
        int count = 0;

        while (startInd < n && endInd < n) {
            if (start[startInd] < end[endInd]) {
                startInd++;
                count++;
                minDay = Math.max(minDay, count);
            } else {
                endInd++;
                count--;
            }
        }
        return minDay;
    }
}
