// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Note that you must do this in-place without making a copy of the array.

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

import java.util.Arrays;

public class lc0283 {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
    public static void moveZeroes(int[] nums) {
        int NZi=0;
        for(int i=0; i<nums.length; i++){
            if (nums[i]!=0) {
                nums[NZi]=nums[i];        
                NZi++;
            }
        }

        while (NZi < nums.length) {
            nums[NZi]=0;
            NZi++;
        }
    }
}