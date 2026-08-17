# Intuition
We need to find the longest contiguous subarray containing at most k zeros.

Since we are allowed to flip at most k zeros into ones, any window with at most k zeros is a valid window.

We can use the Sliding Window technique. Expand the window using high, and whenever the number of zeros becomes greater than k, shrink the window from the left using low.


# Approach
Initialize low = 0, zero = 0, and ans = 0.

Use high to traverse the array and maintain a sliding window from low to high.

If nums[high] == 0, increment zero because the current window contains one more zero.
If zero <= k, the current window is valid because we can flip all its zeros to 1.
If zero > k, the window becomes invalid. We shrink it from the left by moving low.
While shrinking, if nums[low] == 0, decrement zero because that zero is no longer part of the window.
Continue shrinking until zero <= k.
For every valid window, calculate its length using high - low + 1 and update ans with the maximum length.

Since we always maintain at most k zeros in the window, the longest valid window gives the answer.


# Complexity
- Time complexity:
O(n)
- Space complexity:
O(1)
# Code
```java []
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
```