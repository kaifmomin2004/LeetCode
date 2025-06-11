// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

// Example 1:

// Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,4,7,5,3,6,8,9]
// Example 2:

// Input: mat = [[1,2],[3,4]]
// Output: [1,2,3,4]

import java.util.*;

public class lc0498 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read matrix dimensions
        int m = sc.nextInt(); // number of rows
        int n = sc.nextInt(); // number of columns

        int[][] mat = new int[m][n];

        // Read matrix elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        // Call the method
        int[] result = findDiagonalOrder(mat);

        // Print the result
        System.out.println(Arrays.toString(result));

        sc.close();
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        int i = 0, j = 0;
        int n = mat.length, m = mat[0].length;
        int[] ans = new int[n * m];
        int idx = 0;
        while (idx < ans.length) {
            while (i >= 0 && j < m)
                ans[idx++] = mat[i--][j++];

            if (j >= m) {
                j = m - 1;
                i += 2;
            } else
                i = 0;

            while (i < n && j >= 0)
                ans[idx++] = mat[i++][j--];

            if (i >= n) {
                i = n - 1;
                j += 2;
            } else
                j = 0;
        }
        return ans;
    }
}
