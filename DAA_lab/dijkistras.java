package DAA_lab;
import java.util.*;
public class dijkistras {
	int n;
	int vis[] = new int[40];
	int CM[][] = new int[40][40];
	int dist[] = new int[40];
	int src;
	public void init()
	{
		int i,j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = sc.nextInt();
		
		//reading the cost adjacency matrix
		System.out.println("Enter the cost asdjacency matrix");
		for(i = 0;i < n;i ++)
		{
			for(j = 0;j < n;j++)
			{
				CM[i][j] = sc.nextInt();
			}
		}
		
		// reading src vertex
		System.out.println("Enter the source vertex");
		src = sc.nextInt();
		
		//Initialising the visited and distance array
		for(i = 0;i < n;i++)
		{
			vis[i] = 0;
			dist[i] = CM[src][i];
		}
		vis[src] = 1;
		sc.close();
	}
	public void path()
	{
		int i,j,min,unvis=0,v;
		for(j = 1;j < n;j++) 
		{
			for(i = 0;i < n;i++)
			{
				min = 999;
				if((vis[i] != 1) && (dist[i] < min))
				{
					min = dist[i];
					unvis = i;
				}
				//System.out.println(min + " " + unvis);
			}
			//System.out.println("path from "+ src+"to" + unvis +" = ");
			vis[unvis] = 1;
			for(v = 0;v < n;v++)
			{
				if(dist[v] > dist[unvis] + CM[unvis][v])
				{
					//vis[unvis] = 1;
					dist[v] = dist[unvis] + CM[unvis][v];
				}
			}
			//System.out.println(unvis + " ");
		}
		for(v = 0;v < n;v++)
		{
			System.out.print(dist[v] + " ");
		}
	}
	public static void main(String[] args) {
		dijkistras G = new dijkistras();
		G.init();
		G.path();
	}

}