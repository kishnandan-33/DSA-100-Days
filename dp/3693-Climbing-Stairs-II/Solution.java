import java.util.*;
class Solution {
    int[] dp;

    int fun(int i, int n, int[] nums) {
        if (i > n)
            return Integer.MAX_VALUE;
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int c2 = Integer.MAX_VALUE;
        int c3 = Integer.MAX_VALUE;
        int c1 = nums[i + 1 - 1] + 1 + fun(i + 1, n, nums);
        if (i + 1 < n) {
            c2 = nums[i + 2 - 1] + 4 + fun(i + 2, n, nums);
        }
        if (i + 2 < n) {
            c3 = nums[i + 3 - 1] + 9 + fun(i + 3, n, nums);
        }
        return dp[i] = Math.min(c1, Math.min(c2, c3));
    }

    public int climbStairs(int n, int[] costs) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fun(0, n, costs);
    }
}