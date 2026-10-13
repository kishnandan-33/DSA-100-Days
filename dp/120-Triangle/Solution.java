class Solution {
    int[][] dp = new int[202][202];

    int fun(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }
        int down = fun(i + 1, j, triangle);
        int diagonal = fun(i + 1, j + 1, triangle);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 0; i < 202; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return fun(0, 0, triangle);
    }
}