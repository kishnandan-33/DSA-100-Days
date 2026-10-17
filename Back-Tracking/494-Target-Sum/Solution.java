class Solution {
    int fun(int i, int sum, int[] nums, int target) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        int c1 = fun(i + 1, sum + nums[i], nums, target);
        int c2 = fun(i + 1, sum - nums[i], nums, target);
        return c1 + c2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return fun(0, 0, nums, target);
    }
}