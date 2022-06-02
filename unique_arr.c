#include <stdio.h>
void number_dup(int arr[],int n)
{
    int i,j,count;
    for(i = 0;i < n;i++)
    {
        count =1;
        for(j = i+1;j< n;j++)
        {
            if(arr[i] == arr[j])
            {
                arr[j] = 0;
                count+=1;
            }
        }
        if(count>=1 && arr[i] != 0)
            printf("arr[%d]: %d = %d\n",i,arr[i],count);
        else
            continue;
    }
}
int main()
{
    int arr[10],n,i,j;
    printf("Enter the number of elements\n");
    scanf("%d",&n);
    for(i = 0;i <n;i++)
        scanf("%d",&arr[i]);
    for(i = 0;i <n-1;i++)
    {
        for(j = i+1;j < n;j++)
        {
            if(arr[i] == arr[j])
            {
                printf("The array isn't unique\n");
                number_dup(arr,n);
                return 0;
            }
        }
    }
    printf("The array is unique\n");
    
    return 0;
}
