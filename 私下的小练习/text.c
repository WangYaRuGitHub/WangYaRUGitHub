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
		printf("������²����Ʒ�۸�");
		scanf("%.1f", &guessprice);
		/*if (guessprice > price){
			printf("���ˣ�");
		}*/
		if (guessprice > price)
		{
			printf("���ˣ�\n");
		}
		else if (guessprice < price)
		{
			printf("С�ˣ�\n");
		}
		else	{
			printf("��ϲ���¶�����\n");
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
//		printf("��������Ҫ�µ�����:");
//		count++;
//		scanf("%d",&guessnum);
//		if (guessnum > num){
//			printf("�´���\n");
//		}
//		else if (guessnum == num){
//			printf("��ϲ�㣬�¶��ˣ���\n");
//			break;
//		}
//		else{
//			printf("��С�ˣ���\n");
//		}
//	}
//	printf("���²�%d��\n",count);
//	
//	system("pause");
//	return 0;
//}



//���ʮ�������е������
/*int arr[10] = { 0 };
int i = 0;
int max = 0;
for (i = 0; i<10; i++)
{
printf("������a[%d]�����֣� ",i);
scanf("%d", &arr[i]);
}
max = arr[0];
for (i = 1; i<10; i++)
{
if (arr[i]>max)
max = arr[i];
}
printf("max = %d\n", max);*/


//����žų˷���
/*int i = 0;
int j = 0;
printf("�žų˷���\n\n");
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