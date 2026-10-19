import java.util.*;
class Solution {
    int[] dp =new int [10001];
    int fun(int i,int[] nums){
        if(i>=nums.length)return 0;
        if(i==nums.length-1)return 1;
        if(dp[i]!=-1)return dp[i];
        int ans=0;
        for (int k=1;k<=nums[i];k++){
            if(i+k>=nums.length)break;
            int c1=fun(i+k,nums);
            ans=ans|c1;
        }
        return dp[i]=ans;
    }
    public boolean canJump(int[] nums) {
        Arrays.fill(dp,-1);
        return fun(0,nums)==1;
    }
}