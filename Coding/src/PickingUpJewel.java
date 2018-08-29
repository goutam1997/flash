
import java.util.Scanner;
public class PickingUpJewel {
    static int dx[]={0,0,-1,1};
    static int dy[]={-1,1,0,0};
    static int demo[][];
    static int n;
    static int ans;
    static boolean isVisited[][];
    static boolean isSafe(int x,int y)
    {
        return (x>=0 && x<n && y>=0 && y<n);
    }
    
    static void Jewels(int grid[][] , int cur_x,int cur_y,int total)
    {
        if(cur_x==n-1 && cur_y==n-1)
        {
            if(total>ans) {
                ans=total;
                for(int i=0;i<n;i++)    for(int j=0;j<n;j++)    demo[i][j]=grid[i][j];
            }
        return;
        }
        
        for(int i=0;i<4;i++)
        {
            int x = cur_x+dx[i];
            int y = cur_y+dy[i];
            if(isSafe(x,y) && !isVisited[x][y]  && grid[x][y]!=1 )
            {
                if(grid[x][y]==2)
                {
                    isVisited[x][y]=true;
                    grid[x][y]=3;
                    Jewels(grid,x,y,total+1);
                    isVisited[x][y]=false;
                    grid[x][y]=2;
                }
                else
                {
                    isVisited[x][y]=true;
                    grid[x][y]=3;
                    Jewels(grid,x,y,total);
                    grid[x][y]=0;
                    isVisited[x][y]=false;
                }
            }
        }
    }
    
        
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int a=0;a<T;a++)
        {
             n = sc.nextInt();
             int grid[][] = new int[n][n];
             demo =  new int[n][n];
             for(int j=0;j<n;j++)
             {
                 for(int k=0;k<n;k++)
                 {
                     grid[j][k]=sc.nextInt();
                     
                 }
             }
             ans=0;
             isVisited = new boolean[n][n];
             isVisited[0][0]=true;
             if(grid[0][0]==2)
             {
                 grid[0][0]=3;
            Jewels(grid,0,0,1);
             }
            else
            {
                grid[0][0]=3;
            Jewels(grid,0,0,0);
            }
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++)    System.out.print(demo[i][j]+" ");
                System.out.println();
            }
            System.out.println(ans);
            
        }
    }
}