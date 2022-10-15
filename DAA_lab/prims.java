package DAA_lab;
import java.util.Scanner;

public class prims {
    int n;
    int src;
    int CM[][] = new int[24][24];
    int vis[] = new int[24];
    int unvis[] = new int[24];
    public void init()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        n = sc.nextInt();
        
        System.out.println("Enter the cost adj matrix");
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n;j++)
            {
                CM[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Enter the source vertex");
        src = sc.nextInt();
        for(int i = 0;i < n;i++)
        {
            vis[i] = 0;
            unvis[i] = 1;
        }
        
        sc.close();
        //mcst(vis,unvis,n,src,adj_mat);
        return;
    }
    //public static void mcst(int vis[],int unvis[],int n,int src,int adj_mat[][])
    /**
     * 
     */
    public void mcst()
    {
        vis[src] = 1;
        unvis[src] = 0;
        int min,i,j,k,TC = 0;
        int index =0;
        for(i = 1;i < n;i++)
        {
            min = 999;
            for(j = 0;j < n;j++)
            {
                if(vis[j] == 1)
                {
                    for(k = 0;k < n;k++)
                    {
                        if((unvis[k]== 1) && (CM[j][k] != 999))
                        {
                            if(min > CM[j][k])
                            {
                                min = CM[j][k];
                                src = j;
                                index = k;
                            }
                        }
                    }
                }
            }
            vis[index] = 1;
            unvis[index] = 0;
            TC = TC + min;
            System.out.println("path =>" + src + " to " + index + "\tcost : " + min);
        }
        return;
    }
    public static void main(String args[])
    {
        prims G = new prims();
        G.init();
        G.mcst();
    }
}
