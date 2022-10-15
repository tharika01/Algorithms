package DAA_lab;
import java.util.*;
public class merge_arr {
    public static int a[] = new int[25];
    public static void merge_arr1(int low,int mid,int high)
    {
        int h = low,i = low,j = mid+1;
        int b[] = new int[25];
        while((h<= mid) && (j<= high))
        {
            if(a[h] <= a[j])
            {
                b[i++] = a[h++];
                //i++;
                //h++;
            }
            else// if(a[h] > a[j])
            {
                b[i++] = a[j++];
                //i++;
                //j++;
            }
            //i++;
        }
        if(h> mid){
            for(int k = j;k <= high ;k++)
            {
                b[i++] = a[k];
            }
        }
        else //if(j > high)
        {
            for(int k = h;k <= mid ;k++)
            {
                b[i++] = a[k];
            }
        }
        for(int k = low; k <= high;k++)
            a[k] = b[k];
        //return;
    }
    public static void merge_sort(int low, int high)
    {   
        if(low < high)
        {
            int mid = (low + high)/2;
            merge_sort(low,mid);
            merge_sort(mid+1,high);
            merge_arr1(low,mid,high);
        }
        //return;
    }
    public static void main(String args[])
    {
        int low = 0,high;
        int n;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        n = sc.nextInt();
        
        System.out.println("Enter the array elements");
        for(int i = 0;i < n;i++)
        {
            a[i] = sc.nextInt();
        }
        sc.close();

        high = n-1;
        merge_sort(low,high);
        System.out.println("The sorted array is");
        for(int m = 0;m < n;m++)
        {
            System.out.print(a[m] + " ");
        }
    }
}