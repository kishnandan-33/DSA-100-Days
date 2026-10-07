import java.util.*;
class Solution {
    HashMap<Integer, Set<String>> ans = new HashMap<>();
    int m = 26;

    void fun(int i, String s, String c, int b, int remove) {
        if (b < 0 || remove > m)
            return;
        if (i == s.length()) {
            if (b == 0) {
                if (remove < m) {
                    m = remove;
                    ans.clear();
                }
                if (remove == m) {
                    if (ans.containsKey(m)) {
                        ans.get(m).add(c);
                    } else {
                        Set<String> set = new HashSet<>();
                        set.add(c);
                        ans.put(m, set);
                    }
                }
            }
            return;
        }
        if (s.charAt(i) == '(') {
            fun(i + 1, s, c + s.charAt(i), b + 1, remove);
            fun(i + 1, s, c, b, remove + 1);
        } else if (s.charAt(i) == ')') {
            fun(i + 1, s, c + s.charAt(i), b - 1, remove);
            fun(i + 1, s, c, b, remove + 1);

        } else {
            fun(i + 1, s, c + s.charAt(i), b, remove);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        fun(0, s, "", 0, 0);
        for (String str : ans.get(m)) {
            list.add(str);
        }
        return list;
    }
}