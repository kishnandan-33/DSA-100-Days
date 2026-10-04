import java.util.*;
class Solution {
    int[][] dp ;
    int fun(int i,int j,int[][] grid){
        if(i>=grid.length||j>=grid[0].length||grid[i][j]==1)return 0;
        if(i==grid.length-1&&j==grid[0].length-1)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int choice1 =fun(i+1,j,grid);
        int choice2=fun(i,j+1,grid);
        return dp[i][j]=choice1+choice2;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        dp=new int[grid.length+1][grid[0].length+1];
        for(int i=0;i<=grid.length;i++){
            Arrays.fill(dp[i],-1);
            
        }
        return fun(0,0,grid);
       }
    
}