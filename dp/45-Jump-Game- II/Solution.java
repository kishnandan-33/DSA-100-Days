import java.util.*;
class Solution {
    int[] dp =new int [10001];
    int fun(int i,int[] nums){
        if(i>=nums.length)return 10000;
        if(i==nums.length-1)return 0;
        if(dp[i]!=-1)return dp[i];
        int ans=10000;
        for (int k=1;k<=nums[i];k++){
            if(i+k>=nums.length)break;
            int c1=1+fun(i+k,nums);
            ans=Math.min(c1,ans);
        }
        return dp[i]=ans;
    }
    public int jump(int[] nums) {
        Arrays.fill(dp,-1);
        return fun(0,nums);
    }
}