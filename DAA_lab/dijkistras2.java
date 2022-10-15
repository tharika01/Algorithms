package DAA_lab;

import java.util.Scanner;
public class dijkistras2 {
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        //sc.close();
        int CM[][] = new int[40][40];
        for(int i = 1;i <= n;i++)
        {
            for(int j = 1;j <=n;j++)
            {
                CM[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int src  =1;
        int vis[] = new int[40];
        int dist[] = new int[40];
        for(int i =1 ;i <=n;i++)
        {
            dist[i] = CM[src][i];
            vis[i] = 0;
        }
        vis[src] = 1;
        int unvis = 0;
        for(int j = 2;j <=n;j++)
        {
            int min =999;
            
            for(int i = 1;i <=n;i++)
            {
                if(vis[i]==0)
                {
                    if(min > dist[i])
                    {
                        min = dist[i];
                        unvis = i;
                    }
                }
            }
            vis[unvis] = 1;
            for(int v=1;v<=n;v++)
            {
                if(vis[v] == 0)
                {
                    if(dist[v] > dist[unvis] + CM[unvis][v])
                    {
                        dist[v] = dist[unvis] + CM[unvis][v];
                    }
                }
            }
        }
        for(int i = 1;i <=n;i++)
            System.out.print(dist[i]+ " ");
    }
}
