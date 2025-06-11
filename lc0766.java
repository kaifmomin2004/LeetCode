import java.util.*;

/*
LeetCode 766 – Toeplitz Matrix

Given an `m x n` matrix, return `true` if the matrix is Toeplitz. 
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

Example 1:
Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: true

Explanation: 
In the above matrix, the diagonals are:
[1], [2,2], [3,3,3], [4,4], [5], [9]
All diagonals from top-left to bottom-right contain the same elements.

Example 2:
Input:
matrix = [
  [1,2],
  [2,2]
]
Output: false

Constraints:
- m == matrix.length
- n == matrix[i].length
- 1 <= m, n <= 20
- 0 <= matrix[i][j] <= 99
*/

public class lc0766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read matrix dimensions
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        // Read matrix values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Call the method and print result
        boolean result = isToeplitzMatrix(matrix);
        System.out.println(result);

        sc.close();
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        for (int g = 0; g < m; g++) {
            int prev = matrix[0][g];
            for (int i = 0, j = g; j < m && i < n; i++, j++) 
                if (matrix[i][j] != prev)
                    return false;
        }
        for (int g = 1; g < n; g++) {
            int prev = matrix[g][0];
            for (int i = g, j = 0; i < n && j < m; i++, j++) 
                if (matrix[i][j] != prev)
                    return false;
        }
        return true;
    }
}
