import java.util.*;

/*
LeetCode 2402 – Meeting Rooms III

You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means 
that a meeting will be held from starti to endi in one of the rooms. 
All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

1. A meeting can be allocated to any available room.
2. If there are multiple available rooms, the meeting is allocated to the room with the lowest number.
3. If no room is available, the meeting is delayed until a room becomes free. 
   The meeting should be allocated to the room that becomes free the earliest. 
   If multiple rooms become free at the same time, it should be allocated to the room with the lowest number.

Return the number of the room that held the most meetings. 
If there are multiple rooms, return the room with the lowest number.

Example 1:
Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are available. The first meeting is allocated to room 0.
- At time 1, room 1 is available. The second meeting is allocated to room 1.
- At time 2, both rooms are busy. The third meeting is delayed.
- At time 3, room 1 becomes free. The third meeting is allocated to room 1.
- At time 4, both rooms are busy.
- At time 5, room 1 becomes free. The fourth meeting is allocated to room 1.
Room 0 held 1 meeting, room 1 held 3 meetings. Room 1 held the most meetings.

Example 2:
Input: n = 3, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 1

Constraints:
- 1 <= n <= 100
- 1 <= meetings.length <= 10⁵
- meetings[i].length == 2
- 0 <= starti < endi <= 5 * 10⁵
- All the start times of the meetings are unique.
*/

public class lc2402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // number of rooms
            int m = sc.nextInt(); // number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt();
                meetings[i][1] = sc.nextInt();
            }

            int result = mostBooked(n, meetings);
            System.out.println(result);
        }

        sc.close();
    }

    public static int mostBooked(int n, int[][] meetings) {
        // TODO: implement scheduling logic to determine most used room
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        long[] endTime = new long[n];
        int[] noOfMeets = new int[n];

        for (int i = 0; i < meetings.length; i++) {
            int min = 0;
            for (int j = 0; j < n; j++) {
                if (endTime[j] <= meetings[i][0]) {
                    min = j;
                    break;
                }
                min = endTime[j] < endTime[min] ? j : min;
            }
            noOfMeets[min]++;
            if (endTime[min] <= meetings[i][0])
                endTime[min] = meetings[i][1];
            else
                endTime[min] += (meetings[i][1] - meetings[i][0]);
        }

        int max = 0;
        for (int i = 0; i < noOfMeets.length; i++)
            max = noOfMeets[max] >= noOfMeets[i] ? max : i;
        return max;
    }
}
