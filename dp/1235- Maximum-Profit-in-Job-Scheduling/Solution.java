import java.util.*;
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int arr[][] = new int[n][3];
        int dp[] = new int[n];
        Arrays.fill(dp, -1);    
        for(int i = 0; i < n; i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        return fun(arr, 0, dp);
    }
    int fun(int[][] arr, int index, int[] dp){
        if(index == arr.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int skip = fun(arr, index + 1, dp);
        int nextidx = index + 1;
        while (nextidx < arr.length && arr[nextidx][0] < arr[index][1]) {
            nextidx++;
        }
        int take = arr[index][2] + fun(arr, nextidx, dp);
        return dp[index] = Math.max(skip, take);
    }
}