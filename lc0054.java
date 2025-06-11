// Given an m x n matrix, return all elements of the matrix in spiral order.

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class lc0054 {
//     public static void main(String[] args) {
//         

//         spiralOrder(arr);

//         sc.close();
//     }

//     static 

//     public static List<Integer> spiralOrder(int[][] matrix) {

//     }
// }

import java.util.*;

public class lc0054 {
    // Your task: implement this method
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int minC = 0;
        int maxC = matrix[0].length - 1;

        int minR = 0;
        int maxR = matrix.length - 1;

        while (true) {
            // top
            if (minR<=maxR)
            for (int i = minC; i <= maxC; i++)
            list.add(matrix[minR][i]);
            else break;
            minR++;
            
            // right
            if (minC<=maxC)
            for (int i = minR; i <= maxR; i++)
            list.add(matrix[i][maxC]);
            else break;
            maxC--;
            
            // bottom
            if (minR<=maxR)
            for (int i = maxC; i >= minC; i--)
            list.add(matrix[maxR][i]);
            else break;
            maxR--;
            
            // left
            if (minC<=maxC)
            for (int i = maxR; i >= minR; i--)
            list.add(matrix[i][minC]);
            else break;
            minC++;

        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter NxM: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();

        List<Integer> result = spiralOrder(matrix);
        System.out.println("Spiral Order: " + result);

        sc.close();
    }
}
