import java.util.*;

/*
LeetCode 154 – Find Minimum in Rotated Sorted Array II

Suppose an array of length n sorted in ascending order is rotated between 1 and n times.  
The array may contain duplicates.  

Given the rotated array `nums`, return the minimum element of this array.

You must decrease the overall runtime complexity as much as possible.

Example 1:
Input: nums = [1,3,5]
Output: 1

Example 2:
Input: nums = [2,2,2,0,1]
Output: 0

Constraints:
- n == nums.length
- 1 <= n <= 5000
- -10^4 <= nums[i] <= 10^4
- nums is sorted and rotated
*/

public class lc0154 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int min = findMin(nums);
            System.out.println(min);
        }

        sc.close();
    }

    public static int findMin(int[] nums) {
        // TODO: implement logic to find min in rotated array with duplicates
        int s = 0, e = nums.length - 1;
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] <= nums[e]) e--;
            else s=mid+1;
        }
        return nums[s];
    }
}
