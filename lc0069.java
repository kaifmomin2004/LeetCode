import java.util.*;

/*
LeetCode 69 – Sqrt(x)

Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
The returned integer should be non-negative as well.
You must not use any built-in exponent function or operator such as pow(x, 0.5) or x ** 0.5.

Example 1:
Input: x = 4
Output: 2

Example 2:
Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since we only want the integer part, the answer is 2.

Constraints:
- 0 <= x <= 2³¹ - 1
*/

public class lc0069 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            int x = sc.nextInt();
            int ans = mySqrt(x);
            System.out.println(ans);
        }

        sc.close();
    }

    public static int mySqrt(int A) {
        // TODO: implement integer square root logic
        long s=0, e=A;
        while(s<=e){
            long mid=(s+e)/2;
            if(mid*mid==A) return (int) mid;
            else if(mid*mid>A) e=mid-1;
            else s=mid+1;
        }
        
        return (int) e;
    }
}
