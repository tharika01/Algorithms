package DAA_lab;

import java.util.Scanner;
public class tsp {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int n = sc.nextInt();
        int CM[][] = new int[n+1][n+1];
        int set[] = new int[n+1];
        for(int i = 1;i <= n;i++)
        {
            for(int j = 1;j <=n;j++)
                CM[i][j] = sc.nextInt();
            set[i] = 1;
        }
        sc.close();
        int a = g(1,n-1,CM,set,n);
        System.out.println("min cost = "+ a);
    }
    public static int g(int i,int s,int cost[][],int set[],int n)
    {
        int newset[] = new int[n+1];
        int selected[] = new int[n+1];
        for(int l = 0;l <=n;l++)
            newset[l] = set[l];
        newset[i] = 0;
        if(s == 0)
            return cost[i][1];
        int k,j;
        for(k = 0,j = 2;k < s;j++)
        {
            if(newset[j] != 0)
            {
                selected[k] = cost[i][j] + g(j,s-1,cost,newset,n);
                k++;
            }
        }
        int min = 999;
        for(k = 0;k < s;k++)
        {
            if(selected[k] < min)
                min = selected[k];
        }
        return min;
    }
}
