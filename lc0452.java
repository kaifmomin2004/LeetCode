import java.util.*;

/*
LeetCode 452 – Minimum Number of Arrows to Burst Balloons

There are some spherical balloons taped onto a flat wall that represents the XY-plane.  
The balloons are represented as a 2D integer array points where points[i] = [xstart, xend],  
denoting a balloon whose horizontal diameter stretches between xstart and xend.  
You do not know the exact y-coordinates of the balloons.

Arrows can be shot directly vertically (in the y-direction) from different points along the x-axis.  
A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend.  
There is no limit to the number of arrows that can be shot.  
A shot arrow keeps traveling up infinitely.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

Example 1:
Input: points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2

Example 2:
Input: points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4

Example 3:
Input: points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2

Constraints:
- 1 <= points.length <= 10⁵
- points[i].length == 2
- -2³¹ <= xstart < xend <= 2³¹ - 1
*/

public class lc0452 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // number of balloons
            int[][] points = new int[n][2];

            for (int i = 0; i < n; i++) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            int result = findMinArrowShots(points);
            System.out.println(result);
        }

        sc.close();
    }

    public static int findMinArrowShots(int[][] points) {
        // TODO: implement greedy logic to find minimum number of arrows
        Arrays.sort(points, (a,b)->Integer.compare(a[1], b[1]));

        int arrows=1;
        int end=points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]>end ) {
                arrows++;
                end=points[i][1];
            }
        }

        return arrows;
    }
}
