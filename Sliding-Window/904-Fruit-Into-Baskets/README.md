# 904. Fruit Into Baskets

## Problem

Find the **longest subarray with at most 2 distinct numbers**.

## Example

Input:

```text
[1, 2, 3, 2, 2]
```

Output:

```text
4
```

The longest valid subarray is:

```text
[2, 3, 2, 2]
```

It contains only 2 distinct fruit types: `2` and `3`.

---

## Approach

I used the **Sliding Window + HashMap** technique.

* `high` expands the window by moving from left to right.
* `HashMap` stores the frequency of each fruit.
* If the window contains more than 2 distinct fruit types, move `low` forward to shrink the window.
* When the window becomes valid again, update the maximum length.

### Key Condition

```text
map.size() <= 2
```

### Window Length

```text
high - low + 1
```

---

## Why HashMap?

The HashMap stores the frequency of each fruit.

For example:

```text
{2=3, 3=1}
```

This means:

* Fruit `2` appears 3 times.
* Fruit `3` appears 1 time.

When a fruit's frequency becomes `0`, we remove it from the HashMap.

---

## Complexity

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

---

## Key Takeaway

**Longest Subarray + At Most 2 Distinct → Sliding Window + HashMap**

This problem helped me understand how to use the Sliding Window technique with a frequency map.
