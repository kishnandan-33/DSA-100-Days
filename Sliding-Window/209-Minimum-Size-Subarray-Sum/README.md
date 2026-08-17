# Intuition
The goal is to find the smallest contiguous subarray whose sum is greater than or equal to target.

A brute-force approach would check every possible subarray, but that would take O(n²) time.

Since all elements in nums are positive, we can use the Sliding Window technique.

The main idea is:

Expand the window using high until the sum becomes at least target.
Once the sum is >= target, the current window is valid.
Now try to make the window smaller by moving low.
Keep updating the minimum length while the window is still valid.
When the sum becomes smaller than target, expand the window again using high.
Because all numbers are positive, removing an element from the left will always decrease the sum. This makes the sliding window approach possible.


# Approach
Initialize low = 0, sum = 0, and ans = Integer.MAX_VALUE.

Use high to traverse the array and add nums[high] to sum.

Whenever sum >= target, the current window is valid.

Update the minimum length using:

ans = Math.min(ans, high - low + 1);

high - low + 1 is the size of the current window where the sum is greater than or equal to target.

Now shrink the window from the left by subtracting nums[low] from sum and incrementing low.

Continue shrinking while sum >= target to find the smallest valid window.

If no valid subarray is found, return 0; otherwise, return ans.


# Complexity
- Time complexity:
O(n)
- Space complexity:
O(1)
# Code
```java []
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0;
        int ans=Integer.MAX_VALUE;
        int sum=0;
        for(int high=0;high<nums.length;high++){
            sum+=nums[high];
            while(sum>=target){
                ans=Math.min(ans,high-low+1);
                sum-=nums[low];
                low++;
            }
            
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
        
    }
}
```