import java.util.*;

/*
LeetCode 1424 – Diagonal Traverse II

Given a list of lists of integers `nums`, return all elements of `nums` in diagonal order as shown in the below examples.

Example 1:
Input: nums = [
  [1,2,3],
  [4,5,6],
  [7,8,9]
]
Output: [1,4,2,7,5,3,8,6,9]

Explanation:
The diagonals are:
[1], [2,4], [3,5,7], [6,8], [9]

Example 2:
Input: nums = [
  [1,2,3],
  [4,5],
  [6]
]
Output: [1,4,2,6,5,3]

Constraints:
- 1 <= nums.length <= 10^5
- 1 <= nums[i].length <= 10^5
- 1 <= nums[i][j] <= 10^9
- There are at most 10^5 elements in nums.
*/

public class lc1424 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of rows
        int rows = sc.nextInt();
        sc.nextLine(); // consume newline

        List<List<Integer>> nums = new ArrayList<>();

        // Read each row
        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                nums.add(new ArrayList<>());
                continue;
            }
            String[] parts = line.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String part : parts) {
                row.add(Integer.parseInt(part));
            }
            nums.add(row);
        }

        // Call the method and print result
        int[] result = findDiagonalOrder(nums);
        System.out.println(Arrays.toString(result));

        sc.close();
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        int x = 0;
        int max = 1;
        for (int i = 0; i < nums.size(); i++) {
            int t = nums.get(i).size();
            x += t;
            if (max < t)
                max = t;
        }

        int[] a = new int[x];
        int idx = 0;

        for (int g = 0; g < nums.size(); g++) {
            for (int i = g, j = 0; i >= 0; i--, j++) {
                if (j < nums.get(i).size()) {
                    a[idx++] = nums.get(i).get(j);
                }
            }
        }
        for (int g = 1; g < max; g++) {
            for (int i = nums.size() - 1, j = g; i >= 0; i--, j++) {
                if (j < nums.get(i).size()) {
                    a[idx++] = nums.get(i).get(j);
                }
            }
        }

        return a;
    }
}
