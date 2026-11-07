import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int j = n - 2; j >= 0; j--) {
            boolean canreach = false;
            for (int i = 1; i <= nums[j]; i++) {
                if((j+i) >= 0&& (j+i)<n ){
                canreach = canreach | dp[j + i];
                }
            }
            dp[j] = canreach;
        }
        return dp[0];
    }

}