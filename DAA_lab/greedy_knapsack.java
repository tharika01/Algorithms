package DAA_lab;
import java.util.*;
public class greedy_knapsack
{
    int n;
    int max_cap;
    float mat[][] = new float[4][25];
    public void init()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of items");
        n = sc.nextInt();

        System.out.println("Enter profits");
        for(int i = 0;i < n;i++)
            mat[0][i] = sc.nextFloat();
        
        System.out.println("Enter weights");
        for(int i = 0;i < n;i++)
            mat[1][i] = sc.nextFloat();
        //calculating Pi / Wi
        for(int i = 0;i < n;i++)
            mat[2][i] = mat[0][i] / mat[1][i];
        
        //Initialising 4 th row (index 3) to 0 acts as a flag
        for(int i = 0;i < n;i++)
            mat[3][i] = 0;
        
        System.out.println("Enter the max capacity of knapsack");
        max_cap = sc.nextInt();
        
        //Displaying the intialised matrix
        for(int i = 0;i < 4;i++)
        {
            for(int j = 0;j < n;j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    public void knapsack()
    {
        int i,k,j=0;
        float cap = max_cap,TP =0;
        
        while((cap != 0) || (j < n))
        //for(int j =0;j < n;j++)
        {
            float max = mat[2][0];
            k = 0;
            for(i = 1;i < n;i++)
            {
                if((max < mat[2][i]) && (mat[3][i] == 0))
                {
                    max = mat[2][i];
                    k = i;
                }
            }
            mat[2][k] = 0;
            if(cap > mat[1][k])
            {
                //adding object to the knapsack
                cap = cap - mat[1][k];
                System.out.println("Add item "+ (k+1) + " to knapsack");
                TP = TP + mat[0][k];
                mat[3][k] = 1;
            }
            else
            //Entire object cannot be added to the knnapsack 
            {
                if(cap >= (cap/ mat[1][k]))
                {
                    System.out.println("Add item "+ (k+1) + " to Knapsack");
                    TP = TP + mat[0][k] * (cap / mat[1][k]);
                    break;
                }
            }
            j++;
        }
        System.out.println("Total Profit = " + TP);
    }
    public static void main(String args[])
    {
       greedy_knapsack knap = new greedy_knapsack();
       knap.init();
       knap.knapsack();
    }
}