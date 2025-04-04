// Given a string s, calculate its reverse degree.
// The reverse degree is calculated as follows:
// For each character, multiply its position in the reversed alphabet ('a' = 26, 'b' = 25, ..., 'z' = 1) with its position in the string (1-indexed).
// Sum these products for all characters in the string.
// Return the reverse degree of s.

// Input: s = "abc"
// Output: 148
// Explanation:
// Letter	Index in Reversed Alphabet	Index in String	Product
// 'a'	26	1	26
// 'b'	25	2	50
// 'c'	24	3	72
// The reversed degree is 26 + 50 + 72 = 148.

public class lc3498 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(reverseDegree(s));
    }

    public static int reverseDegree(String s) {
        int ans=0;
        for(int i=0; i<s.length(); i++)
            ans+=(26-(s.charAt(i)-'a'))*(i+1);
        return ans;
    }    
}