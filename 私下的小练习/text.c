#include<stdio.h>
#include<windows.h>
#include<stdlib.h>
#include<time.h>
#pragma warning (disable:4996)

int main()
{
	double price = 7890.0;
	double guessprice = 0.0;
	for (;;)
	{
		printf("请输入猜测的商品价格：");
		scanf("%.1f", &guessprice);
		/*if (guessprice > price){
			printf("大了！");
		}*/
		if (guessprice > price)
		{
			printf("大了！\n");
		}
		else if (guessprice < price)
		{
			printf("小了！\n");
		}
		else	{
			printf("恭喜，猜对啦！\n");
			break;
		}

	}
	system("pause");
	return 0;
}

//int main()
//{
//	int num = 0;
//	int guessnum = 0;
//	int count = 0;
//	srand(time(NULL));
//	num = rand() % 100;
//	while (1){
//		printf("请输入你要猜的数字:");
//		count++;
//		scanf("%d",&guessnum);
//		if (guessnum > num){
//			printf("猜大了\n");
//		}
//		else if (guessnum == num){
//			printf("恭喜你，猜对了！！\n");
//			break;
//		}
//		else{
//			printf("猜小了！！\n");
//		}
//	}
//	printf("共猜测%d次\n",count);
//	
//	system("pause");
//	return 0;
//}



//求出十个数字中的最大数
/*int arr[10] = { 0 };
int i = 0;
int max = 0;
for (i = 0; i<10; i++)
{
printf("请输入a[%d]的数字： ",i);
scanf("%d", &arr[i]);
}
max = arr[0];
for (i = 1; i<10; i++)
{
if (arr[i]>max)
max = arr[i];
}
printf("max = %d\n", max);*/


//输出九九乘法表
/*int i = 0;
int j = 0;
printf("九九乘法表：\n\n");
for (int i = 1; i <= 9; i++){
for (int j = 1; j <= i; j++){
printf("%d * %d = %d",i,j,i*j);
}
printf("\n");
}*/



/*printf("%d\n",sizeof(char));
printf("%d\n",sizeof(short));
printf("%d\n",sizeof(int));
printf("%d\n",sizeof(long));
printf("%d\n",sizeof(long long));
printf("%d\n",sizeof(float));
printf("%d\n", sizeof(double));
printf("%d\n",sizeof(long double));*/