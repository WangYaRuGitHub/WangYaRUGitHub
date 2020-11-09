#include<stdio.h>
int main()
{
    int N,f,time;
    scanf("%d",&N);
	f = N/12;
    time = f*4+2;
    printf("%d\n",time);
    return 0;
}