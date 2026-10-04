## Intuition

We need to find the number of different paths from the **top-left** cell `(0,0)` to the **bottom-right** cell of the grid.

We can move only in two directions:

- **Down** → `(i + 1, j)`
- **Right** → `(i, j + 1)`

Some cells contain an obstacle represented by `1`. We cannot move through an obstacle.

The main idea is to use **recursion**.

For any cell `(i,j)`, there are at most two choices:

```text
    (i,j)
    /     \
    Down     Right
    ↓          →
    (i+1,j)     (i,j+1)
```

Therefore, the number of paths from `(i,j)` is:

```text paths from Down + paths from Right ```

So:

```text fun(i,j) = fun(i+1,j) + fun(i,j+1) ```

There are some special cases:

- If we go outside the grid → `0` paths.
- If the current cell is an obstacle → `0` paths.
- If we reach the destination → `1` path.

### Why do we need DP?

If we use only recursion, the same cell can be calculated multiple times.

For example:

```text
    (0,0)
    /     \
    ↓       →
    (1,0)   (0,1)
    \     /
    ↓   ↓
    (1,1)
```

Both `(1,0)` and `(0,1)` can reach `(1,1)`.

Without DP, `fun(1,1)` would be calculated again and again.

So we store the answer of every calculated cell in:

```text dp[i][j] ```

Here:

```text dp[i][j] = number of valid paths from (i,j) to destination ```

This is called **Top-Down Dynamic Programming using Memoization**.

---

## Approach

We solve the problem using **recursion + memoization**.

### Step 1: Start from the top-left cell

The answer starts from:

```java fun(0, 0, grid) ```

Here:

```text i = 0 j = 0 ```

represents the top-left cell.

The function will calculate how many valid paths exist from this cell to the destination.

---

### Step 2: Handle out-of-bound cells

```java
if(i >= grid.length || j >= grid[0].length)
    return 0;
```

Suppose the grid has `3` rows.

Valid row indices are:

```text 0, 1, 2 ```

If `i` becomes `3`, we have gone outside the grid.

Similarly, if the grid has `3` columns:

```text 0, 1, 2 ```

If `j` becomes `3`, we are outside the grid.

Such a path is invalid, so we return:

```text 0 ```

---

### Step 3: Handle obstacles

```java
if(grid[i][j] == 1)
    return 0;
```

If the current cell contains `1`, it is an obstacle.

For example:

```text 0 0 0 0 1 0 0 0 0 ```

The middle cell cannot be used.

So:

```text fun(1,1) = 0 ```

because there is no valid path through that cell.

---

### Step 4: Handle the destination

```java
if(i == grid.length - 1 && j == grid[0].length - 1)
    return 1;
```

The destination is:

```text (row - 1, column - 1) ```

For example, for a `3 × 3` grid:

```text 0 0 0 0 0 0 0 0 X ```

The destination is:

```text (2,2) ```

If our recursion reaches `(2,2)`, it means we have successfully found one valid path.

Therefore:

```text fun(2,2) = 1 ```

---

### Step 5: Check the DP array

```java
if(dp[i][j] != -1)
    return dp[i][j];
```

Initially, every value of `dp` is `-1`.

So:

```text -1 = not calculated yet ```

Suppose we calculate:

```text fun(1,2) = 3 ```

Then we store:

```text dp[1][2] = 3 ```

If later we need `fun(1,2)` again, instead of calculating it again, we simply return:

```text dp[1][2] ```

which is `3`.

This avoids repeated work.

---

### Step 6: Move Down

```java int choice1 = fun(i + 1, j, grid); ```

From `(i,j)`, we move one row down:

```text (i,j) ↓ (i+1,j) ```

`choice1` stores the number of paths obtained by choosing the **down** direction.

---

### Step 7: Move Right

```java int choice2 = fun(i, j + 1, grid); ```

From `(i,j)`, we move one column right:

```text (i,j) → (i,j+1) ```

`choice2` stores the number of paths obtained by choosing the **right** direction.

---

### Step 8: Add both choices

```java return dp[i][j] = choice1 + choice2; ```

At every valid cell, we can either go down or right.

Therefore:

```text
# total paths
paths through down
- paths through right
```

So:

```text dp[i][j] = choice1 + choice2 ```

We also store this answer in `dp[i][j]`.

---

## DP State

The most important thing to understand is what `dp[i][j]` represents.

```text dp[i][j] ```

means:

> **The number of valid paths from cell `(i,j)` to the bottom-right destination.**

For example:

```text dp[0][0] ```

is the final answer because we start from `(0,0)`.

And:

```text dp[1][2] ```

means the number of ways to reach the destination if we are currently standing at `(1,2)`.

---

## Recurrence

For a normal cell:

```text dp[i][j] = dp[i+1][j] + dp[i][j+1] ```

because we have two choices:

```text Down  → (i+1,j) Right → (i,j+1) ```

### Base Cases

```text Outside grid → 0 Obstacle      → 0 Destination   → 1 ```

So the complete logic is:

```
if outside grid or obstacle
        return 0

if destination
        return 1

if already calculated
        return dp[i][j]

down  = fun(i+1,j) right = fun(i,j+1)

dp[i][j] = down + right

return dp[i][j]
```

## Dry Run

Consider:

```text grid =

0 0 0 0 1 0 0 0 0 
```

We start from:

```text (0,0) ```

From `(0,0)` we have two choices:

```text
    (0,0)
    /     \
    ↓       →
    (1,0)     (0,1)
```

From `(1,0)`:

```text (1,0) ↓ (2,0) ```

From `(2,0)`:

```text (2,0) → (2,1) → (2,2) ```

This gives one valid path:

```text Down → Down → Right → Right ```

Now consider the right side:

```text (0,0) → (0,1) ```

From `(0,1)`, going down reaches:

```text (1,1) ```

But:

```text grid[1][1] = 1 ```

so that path gives:

```text 0 ```

Therefore, `(0,1)` must go right:

```text (0,1) → (0,2) → (1,2) → (2,2) ```

This gives another valid path:

```text Right → Right → Down → Down ```

Therefore the final answer is:

```text 2 ```

---

## DP Initialization

In the code:

```java dp = new int[grid.length + 1][grid[0].length + 1]; ```

we create the DP array.

Then:

```java
for(int i = 0; i <= grid.length; i++) {
    Arrays.fill(dp[i], -1);
}
```

sets every value to `-1`.

Why `-1`?

Because the number of paths can never be negative.

Therefore, `-1` can safely represent:

```text This state has not been calculated yet. ```

For example:

```text
 dp initially:

-1 -1 -1 -1 -1 -1 -1 -1 -1 
```

After calculating some cells:

```text
 2  1 -1 1 -1 -1 1  1  1 
```

Now, if we reach a cell whose DP value is already calculated, we use that value directly.

---

## Why `+1` in DP Size?

Your code uses:

```java dp = new int[grid.length + 1][grid[0].length + 1]; ```

The extra row and column are **not actually required**.

Because the function checks:

```java
if(i >= grid.length || j >= grid[0].length)
    return 0;
```

before accessing:

```java dp[i][j] ```

So this is also sufficient:

```java dp = new int[grid.length][grid[0].length]; ```

Your current code with `+1` is still correct; it just creates a slightly larger DP array.

---

## Why Memoization Makes It Efficient

Without DP, every cell can generate two more recursive calls.

The recursion can become exponential because the same states are repeatedly calculated.

With memoization:

```java
if(dp[i][j] != -1)
    return dp[i][j];
```

each `(i,j)` state is calculated only once.

For example, if:

```text m = **100** n = **100** ```

there are only:

```text **100** × **100** = 10,**000** ```

possible states.

We calculate each state at most once.

Therefore, the solution becomes much more efficient.

---

## Complexity

Let:

```text m = number of rows n = number of columns ```

### Time Complexity

There are at most `m × n` different cells.

Each cell is calculated only once because of memoization.

Therefore:

```text Time Complexity = O(m × n) ```

### Space Complexity

The DP array contains:

```text m × n ```

elements.

So:

```text DP Space = O(m × n) ```

The recursion stack can go as deep as approximately:

```text m + n ```

because at every step we either increase `i` or increase `j`.

So:

```text Recursion Stack = O(m + n) ```

Overall:

```text Space Complexity = O(m × n) ```

because the DP array is the dominant space.

---

## Code

```java class Solution {

    int[][] dp;

    int fun(int i, int j, int[][] grid) {

    // Out of bounds or obstacle
    if(i >= grid.length || j >= grid[0].length || grid[i][j] == 1)
    return 0;

    // Destination reached
    if(i == grid.length - 1 && j == grid[0].length - 1)
    return 1;

    // Already calculated
    if(dp[i][j] != -1)
    return dp[i][j];

    // Move down
    int choice1 = fun(i + 1, j, grid);

    // Move right
    int choice2 = fun(i, j + 1, grid);

    // Store the answer
    return dp[i][j] = choice1 + choice2;
    }

    public int uniquePathsWithObstacles(int[][] grid) {

        dp = new int[grid.length + 1][grid[0].length + 1];

    // Initialize DP with -1
    for(int i = 0; i <= grid.length; i++) {
    Arrays.fill(dp[i], -1);
    }

    return fun(0, 0, grid);
    }
}
```

---

## Important Points to Remember

```text fun(i,j) ```

means:

> Number of paths from `(i,j)` to destination.

The two choices are:

```text fun(i+1,j)       → Down fun(i,j+1)       → Right ```

The recurrence is:

```text dp[i][j] = fun(i+1,j) + fun(i,j+1) ```

Base cases:

```text Outside grid → 0 Obstacle      → 0 Destination   → 1 ```

And:

```java
if(dp[i][j] != -1)
    return dp[i][j];
```

is what converts the normal recursive solution into **Top-Down DP (Memoization)**.