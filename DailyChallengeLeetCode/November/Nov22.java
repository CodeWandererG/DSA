package DailyChallengeLeetCode.November;

import java.util.LinkedList;
import java.util.Queue;

public class Nov22 {
    public class pair{
        public int r;
        public int c;
        public pair(int r,int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][] = new int[m][n];
        Queue<pair> q = new LinkedList<>();
        for(int i =0;i<guards.length;i++){
            int a = guards[i][0];
            int b = guards[i][1];
            grid[a][b]=1;
            q.offer(new pair(a,b));
        }
        for(int i=0;i<walls.length;i++){
            int a = walls[i][0];
            int b = walls[i][1];
            grid[a][b]= -1;
        }
        while(!q.isEmpty()){
            pair cur = q.poll();
            int row = cur.r;
            int col = cur.c;
            //up
            for(int i =row-1;i>=0;i--){
                if(grid[i][col]==1||grid[i][col]==-1){
                    break;
                }
                grid[i][col] =2;
            }
            //down
            for(int i = row+1;i<m;i++){
                if(grid[i][col]==1||grid[i][col]==-1){
                    break;
                }
                grid[i][col]=2;
            }
            //left
            for(int i =col-1;i>=0;i--){
                if(grid[row][i]==1||grid[row][i]==-1)break;
                grid[row][i]=2;
            }
            //right
            for(int i =col+1;i<n;i++){
                if(grid[row][i]==1||grid[row][i]==-1)break;
                grid[row][i]=2;
            }
        }
        int cnt =0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==0)cnt++;
            }
        }
        return cnt;
    }
}
