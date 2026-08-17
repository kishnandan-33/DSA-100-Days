class Solution {
    public int longestOnes(int[] nums, int k) {
        int zero=0;
        int low=0;
        int ans=0;
        for(int high=0;high<nums.length;high++){
            if(nums[high]==0) zero+=1;

            while(zero>k){
                if(nums[low]==0) zero-=1;
                low++;
                
            }

            ans=Math.max(ans,high-low+1);
        }
        return ans;
        
    }
}