# Intuition

The main idea is to use **Backtracking**.

We need to find all possible combinations of `candidates` whose sum is equal to `target`.

For every candidate, we have **two choices**:

1. **Take** the current candidate.
2. **Skip** the current candidate.

For example:

`candidates = [2,3,6,7]` and `target = 7`.

If we are currently considering `2`, we have two choices:

- **Take `2`** → `current = [2]`, `target = 5`
- **Skip `2`** → move to the next candidate `3`

If we take `2`, we can take it again because each candidate can be used multiple times:

`[2] → [2,2] → [2,2,3]`

Here:

`2 + 2 + 3 = 7`

So `[2,2,3]` is a valid combination.

Similarly, if we skip `2`, then skip `3` and `6`, we can take `7`:

`[7]`

Since `7 = target`, `[7]` is also a valid combination.

Therefore, the final answer is:

`[[2,2,3],[7]]`

The important part is that when we **take** a candidate, we keep the same `index` because the candidate can be reused. When we **skip** a candidate, we move to `index + 1`.


# Approach

We use a recursive `backtrack()` function to explore all possible combinations.

The function takes four important parameters:

- `target` → the remaining sum that we need to make.
- `index` → the current candidate we are considering.
- `current` → the combination we are currently building.
- `ans` → stores all valid combinations.

### 1. Base Case: `target == 0`

```java
if(target == 0){
    ans.add(new ArrayList<>(current));
    return;
}
```
If `target == 0`, it means that the current combination has reached the required sum.

For example:

```text
current = [2,2,3]
target = 0
```
Since:

```text
2 + 2 + 3 = 7
```
the remaining `target` becomes `0`.

Therefore, `[2,2,3]` is a valid combination, so we add it to `ans`:

```java
ans.add(new ArrayList<>(current));
```
We use new ArrayList<>(current) because current is modified later during backtracking. This creates a separate copy of the current combination.

After adding the valid combination, we use return because there is no need to explore further from this state
.
### 2. Invalid Case: target < 0 or index == candidates.length
```
if(target < 0 || index == candidates.length){
    return;
}
```
We stop the recursion in two cases:

target < 0 → the current combination has exceeded the target.
index == candidates.length → there are no more candidates left to explore.

For example:

target = 1
candidate = 2

If we take 2:

target = 1 - 2
       = -1

Since target < 0, this path cannot produce a valid combination, so we return
### 3. Take the Current Candidate
First, we add the current candidate to current:

```current.add(candidates[index]);```

Then we recursively call:

```backtrack(candidates,
          target - candidates[index],
          index,
          current,
          ans);
```

Here, the target is reduced by the value of the current candidate.

For example:

```current = []
target = 7
candidates[index] = 2
```

After taking 2:

```current = [2]
target = 5
```

We keep the same index because a candidate can be used multiple times.

For example:
```
[2]
[2,2]
[2,2,2]
```
### 4. Backtrack

After exploring the "Take" choice, we remove the last element:

```java
current.remove(current.size() - 1);
```

This is called Backtracking.

For example:

```current = [2,2,3]```

After returning from that recursive call:

```current = [2,2]```

Now we can explore another possible combination.

The basic pattern is:

```Choose
   ↓
Explore
   ↓
Undo the choice
   ↓
Try another choice
```

### 5. Skip the Current Candidate

After backtracking, we skip the current candidate:

```backtrack(candidates,
          target,
          index + 1,
          current,
          ans);
```

Here, target remains the same because we did not take the current candidate.

But index becomes index + 1, so we move to the next candidate.

For example:

```Current candidate = 2
        ↓
     Skip 2
        ↓
Move to candidate 3
```

Therefore, the main rule is:

```Take → target decreases, index stays same
Skip → target stays same, index increases
```
# Complexity
- Time complexity: O(2^t) approximately, where t is the maximum number of elements that can be selected before reaching or exceeding the target.
 
- Space complexity: O(t) for the recursion stack and the current combination, excluding the space used to store the final answer.

# Code
```java []
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
         backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
        
    
    void backtrack(int[] candidates ,int target ,int index ,List<Integer> current,
                            List<List<Integer>> ans ){
                                if(target==0){
                                    ans.add(new ArrayList<>(current));
                                    return ;
                                }
                                if(target<0 || index==candidates.length){
                                    return; 
                                }
                                current.add(candidates[index]);
                                backtrack(candidates, target - candidates[index],
                  index, current, ans);
                            current.remove(current.size()-1);
                            backtrack(candidates,target,index+1,current,ans);
                            
                            }
}

```