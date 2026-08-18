
## Problem

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

You may assume that each input has exactly one solution, and you may not use the same element twice.

The answer can be returned in any order.
# Intuition


The goal is to find **two numbers whose sum is equal to `target`**.

Instead of checking every possible pair using two loops, we use a **HashMap** to make the search faster.

For every element `nums[i]`, we calculate the number required to reach the target:

```text
need = target - nums[i]
```
## Approach

1. Create an empty `HashMap` to store each number and its index.

2. Traverse the array from left to right using a loop.

3. For every element `nums[i]`, calculate the required number:
   ```text
   need = target - nums[i]
## Complexity Analysis

### Time Complexity

**O(n)**

We traverse the array only once, and HashMap operations such as `containsKey()`, `get()`, and `put()` take **O(1)** average time.

Therefore, the overall time complexity is:

```text
O(n)
```
# Code
```java []
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
```
