#include <stdio.h>
#include <string.h>
void guess_num(int high,int low);
int main()
{
	int range,low = 0,high,mid;
	printf("Enter the max limit\n");
	scanf("%d",&range);
	high = range;
	printf("Choose a number between 0 and %d\n",range);
	guess_num(high,low);
	return 0;
}	
void guess_num(int high,int low)
{
	int mid;
	char ans[3];
	//printf("\n%d %d",high,low);
	mid = (low + high)/2;
	printf("h = %d ,l = %d, mid = %d\n",high,low,mid);
	printf("Is the number you chose %d ??\n",mid);
	scanf("%s",ans); 
	if(!(strcmp(ans,"yes")))
	{
		printf("The number you chose is %d\n",mid);
		return;
	}
	printf("Is the number you chose greater than %d\n",mid);
	scanf("%s",ans);
	if(!(strcmp(ans,"yes")))
	{
		low = mid+1;
		guess_num(high,low);
	}
	else
	{
		high = mid - 1;
		guess_num(high,low);
	}	
}				
