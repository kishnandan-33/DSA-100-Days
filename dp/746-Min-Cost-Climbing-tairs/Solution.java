import java.util.*;
class Solution {
    int[] dp ;
    int fun(int i,int[] nums){
        if(i>=nums.length)return 0;
        if(dp[i]!=-1)return dp[i];
        int c1=nums[i]+fun(i+1,nums);
        int c2=nums[i]+fun(i+2,nums);
        
        return dp[i]=Math.min(c1,c2);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(fun(0,cost),fun(1,cost));
    }
}