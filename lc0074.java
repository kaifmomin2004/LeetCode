import java.util.*;

/*
LeetCode 74 – Search a 2D Matrix

You are given an m x n integer matrix matrix with the following two properties:
1. Each row is sorted in non-decreasing order.
2. The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: 
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
], target = 3
Output: true

Example 2:
Input: 
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
], target = 13
Output: false

Constraints:
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 100
- -10^4 <= matrix[i][j], target <= 10^4
*/

public class lc0074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            // Read matrix dimensions
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[][] matrix = new int[m][n];

            // Read matrix elements
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            // Read target
            int target = sc.nextInt();

            // Call the method and print result
            boolean found = searchMatrix(matrix, target);
            System.out.println(found);
            sc.close();
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // TODO: implement binary search logic on 2D matrix
        int n = matrix.length, m = matrix[0].length;
        int s = 0, e = m * n - 1;

        while (s <= e) {
            int mid = (s + e) / 2;
            int j = mid % m, i = mid / m;
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                e = mid - 1;
            else
                s = mid + 1;
        }

        return false;
    }
}
