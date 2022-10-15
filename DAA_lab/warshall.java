package DAA_lab;
import java.util.*;

public class warshall {
	int n;
	int adj_mat[][] = new int[40][40];
	public void init()
	{
		int i,j;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = sc.nextInt();
		
		//reading the cost adjacency matrix
		System.out.println("Enter the adjacency matrix");
		for(i = 0;i < n;i ++)
		{
			for(j = 0;j < n;j++)
			{
				adj_mat[i][j] = sc.nextInt();
			}
		}
		sc.close();
	}
	void transitive_closure()
	{
		int i,j,k;
		for(k = 0;k < n;k++)
		{
			for(i = 0;i < n;i++)
			{
				for(j = 0;j< n;j++)
				{
					if(adj_mat[i][j] != 1)
					{
						adj_mat[i][j] = adj_mat[i][k] * adj_mat[k][j];
					}
				}
			}
		}
	}
	void display()
	{
		int i,j;
		for(i = 0;i < n;i ++)
		{
			for(j = 0;j < n;j++)
			{
				System.out.print(adj_mat[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	public static void main(String[] args) {
		warshall T = new warshall();
		T.init();
		T.transitive_closure();
		System.out.println("The required transitive closure is ");
		T.display();
	}

}