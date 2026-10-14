class Solution {
    public int dominantIndices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int sum = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int cnt = n - i - 1;
            if (nums[i] > sum / cnt) {
                ans++;
            }
            sum += nums[i];
        }
        return ans;
    }
}