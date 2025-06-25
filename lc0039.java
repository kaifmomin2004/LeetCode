import java.util.*;

/*
LeetCode 39 – Combination Sum

Given an array of distinct integers candidates and a target integer target, 
return a list of all unique combinations of candidates where the chosen numbers sum to target. 
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. 
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []

Constraints:
- 1 <= candidates.length <= 30
- 2 <= candidates[i] <= 40
- All elements of candidates are distinct.
- 1 <= target <= 40
*/

public class lc0039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // number of candidates
            int[] candidates = new int[n];
            for (int i = 0; i < n; i++) {
                candidates[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            List<List<Integer>> result = combinationSum(candidates, target);
            for (List<Integer> combination : result) {
                System.out.print("[");
                for (int num : combination) {
                    System.out.print(num + ", ");
                }
                System.out.print("], ");
            }
            System.out.println();
            li.clear();
        }

        sc.close();
    }

    static List<List<Integer>> li;
    static ArrayList<Integer> sum;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // TODO: implement backtracking logic
        if (li == null) {
            li = new ArrayList<>();
            sum = new ArrayList<>();
        }

        if (target == 0) {
            li.add(new ArrayList<>(sum));
            return li;
        }
        if (target < 0) {
            return li;
        }
        for (int i : candidates) {
            if (sum.isEmpty() || sum.get(sum.size() - 1) <= i) {
                sum.add(i);
                combinationSum(candidates, target-i);
                sum.remove(sum.size()-1);
            }
        }
        return li;
    }
}
