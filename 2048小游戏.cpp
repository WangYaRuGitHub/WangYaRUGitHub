#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h>
#include <Windows.h>

#define SIZE	4
int code[SIZE][SIZE]={0};/*游戏中的16个格子*/
int temp[SIZE];/*中间变量*/
int move=0;/*移动次数*/
int score=0;/*分数*/

void print(void)/*显示游戏界面*/
{
	int i,j,k;
	
	system("cls");/*清屏*/
	printf("2048游戏\n");
	printf("W--UP  A--LEFT  S--DOWN  D--RIGHT  0--EXIT\n");
	printf("Score:%d Move:%d\n",score,move);
	printf("|");
	for (k=0; k<SIZE; k++)
	{
		if (k == SIZE-1)
			printf("\b");  //最后一个元素要输出'|',进行退格
		printf("-----");
	}
	printf("|\n");/*显示横向分隔线*/
	for(i=0;i<=SIZE-1;i++)
	{
		for(j=0;j<=SIZE-1;j++)
		{
			if(code[i][j]==0)
			{
				printf("|    ");/*0显示空格*/
			}
			else
			{
				/*根据数字的大小位数将此放到字符串str中
				*/
				char str[5]="";
				if (code[i][j] < 10)
					sprintf(str, "  %d ", code[i][j]);
				else if (code[i][j] < 100)
					sprintf(str, " %d ", code[i][j]);
				else if (code[i][j] < 1000)
					sprintf(str, " %d", code[i][j]);
				else
					sprintf(str, "%d", code[i][j]);

				printf("|%s",str);/*显示数字和分隔线*/
			}
		}
		printf("|\n|");
		for (k=0; k<SIZE; k++)
		{
			if (k == SIZE-1)
				printf("\b");
			printf("-----");
		}
		printf("|\n");/*显示横向分隔线*/
	}
}

void add(void)/*对中间变量数组进行处理*/
{
	//相邻相同的相加
	int begainPos=0, secondPos;
	int putPos, curPos;
	while (begainPos < SIZE)
	{
		if (temp[begainPos] != 0)
		{
			secondPos = begainPos+1;
			while (secondPos < SIZE && temp[secondPos]==0)
			{
				secondPos++;
			}
			if (secondPos == SIZE)
				break;
			/*如果相邻的元素相等，则相加，将结果放到beginpos中，并将secondpos清空
			*/
			if (temp[begainPos] == temp[secondPos])
			{
				score += temp[secondPos];
				temp[begainPos] += temp[secondPos];
				temp[secondPos] = 0;
				begainPos = secondPos+1;
			}
			else
			{
				begainPos = secondPos;
			}
		}
		else
			begainPos++;
	}
	//去掉0
	/*
	将temp数组的结果进行整理
	*/
	putPos = curPos = 0;
	while (curPos < SIZE)
	{
		if (temp[curPos] != 0)
		{
			temp[putPos] = temp[curPos];
			putPos++;
		}
		curPos++;
	}
	while (putPos < SIZE)
		temp[putPos++] = 0;
}
void initRand()
{
	srand((unsigned)time(NULL));/*设置随机数的起点*/
}
void putRandNumber()
{
	int randNum;
	int i,j,count;
	int num[]={2,4};

	randNum = rand() % (sizeof(num)/sizeof(num[0])); //随机得到0，1下标

	count = 0;
	i = rand() % SIZE;
	j = rand() % SIZE;
	while(count < SIZE*SIZE)
	{
		if (code[i][j] == 0)
		{
			code[i][j] = num[randNum];
			break;
		}
		count++;
		j++;
		if (j == SIZE)
		{
			j = 0;
			i++;
			if (i == SIZE)
				i = 0;
		}
	}
}
int main()
{
	char dir;
	int i,j;

	initRand();
	putRandNumber();
	putRandNumber();
	print();
	while (1)
	{
		dir = getch();
		switch (dir)
		{
		case 'w':	//上
			for (i=0; i<SIZE; i++)
			{
				/*将同一列元素移到数组temp中进行操作*/
				for (j=0; j<SIZE; j++)  //
					temp[j] = code[j][i];
				add();
				/*将操作完成后的temp内容移动到同一列格子中
				*/
				for (j=0; j<SIZE; j++) 
					code[j][i] = temp[j];
			}
			move++;
			break;
		case 's':	//下
			
			for (i=0; i<SIZE; i++)
			{
				/*将格子中同一列元素反序移动到数组temp中进行操作
				*/
				for (j=0; j<SIZE; j++)
					temp[j] = code[SIZE-1-j][i];
				add();
				/*将操作完成后的temp中数组的结果反序移动到同一列格子中
				*/
				for (j=0; j<SIZE; j++)
					code[SIZE-1-j][i] = temp[j];
			}
			move++;
			break;
		case 'a':	//左
			for (i=0; i<SIZE; i++)
			{
				/*将格子中同一行元素移动到数组temp中进行操作
				*/
				for (j=0; j<SIZE; j++)
					temp[j] = code[i][j];
				add();
				/*将操作完的temp结果移动到格子中同一行
				*/
				for (j=0; j<SIZE; j++)
					code[i][j] = temp[j];
			}
			move++;
			break;
		case 'd':	//右
			for (i=0; i<SIZE; i++)
			{
				/*将格子中的同一行元素反序移动到temp数组中进行操作
				*/
				for (j=0; j<SIZE; j++)
					temp[j] = code[i][SIZE-1-j];
				add();
				/*将操作完的temp数组反序移动到格子的同一行中
				*/
				for (j=0; j<SIZE; j++)
					code[i][SIZE-1-j] = temp[j];
			}
			move++;
			break;
		default:
			continue;
		}
		putRandNumber();//放随机元素
		print();//将新结果打印到屏幕上
	}
}