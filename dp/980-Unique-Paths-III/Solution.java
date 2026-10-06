class Solution {
    int fun(int i,int j,int[][] grid,int[][] vis){
        if(i>=grid.length||j>=grid[0].length||i<0||j<0||grid[i][j]==-1)return 0;
        if(grid[i][j]==2){
            for(int a=0;a<grid.length;a++){
                for(int b=0;b<grid[0].length;b++){
                    System.out.println(vis[i][j]);
                    if(grid[a][b] == 0 && vis[a][b] == 0)return 0;
                }
            }
            return 1;
        }
        if(vis[i][j]!=0)return 0;
        vis[i][j]=-1;
        int c1=fun(i+1,j,grid,vis);
        int c2=fun(i,j+1,grid,vis);
        int c3=fun(i,j-1,grid,vis);
        int c4=fun(i-1,j,grid,vis);
        vis[i][j]=0;
        return c1+c2+c3+c4;
    }
    public int uniquePathsIII(int[][] grid) {
       int r=0;
        int c=0;
        int[][] vis= new int[grid.length][grid[0].length];
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1){
                r=i;
                c=j;
                break;
            }
        }
       }
       return fun(r,c,grid,vis); 
    }
}