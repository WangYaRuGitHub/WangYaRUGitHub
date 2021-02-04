#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h>
#include <Windows.h>

#define SIZE	4
int code[SIZE][SIZE]={0};/*��Ϸ�е�16������*/
int temp[SIZE];/*�м����*/
int move=0;/*�ƶ�����*/
int score=0;/*����*/

void print(void)/*��ʾ��Ϸ����*/
{
	int i,j,k;
	
	system("cls");/*����*/
	printf("2048��Ϸ\n");
	printf("W--UP  A--LEFT  S--DOWN  D--RIGHT  0--EXIT\n");
	printf("Score:%d Move:%d\n",score,move);
	printf("|");
	for (k=0; k<SIZE; k++)
	{
		if (k == SIZE-1)
			printf("\b");  //���һ��Ԫ��Ҫ���'|',�����˸�
		printf("-----");
	}
	printf("|\n");/*��ʾ����ָ���*/
	for(i=0;i<=SIZE-1;i++)
	{
		for(j=0;j<=SIZE-1;j++)
		{
			if(code[i][j]==0)
			{
				printf("|    ");/*0��ʾ�ո�*/
			}
			else
			{
				/*�������ֵĴ�Сλ�����˷ŵ��ַ���str��
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

				printf("|%s",str);/*��ʾ���ֺͷָ���*/
			}
		}
		printf("|\n|");
		for (k=0; k<SIZE; k++)
		{
			if (k == SIZE-1)
				printf("\b");
			printf("-----");
		}
		printf("|\n");/*��ʾ����ָ���*/
	}
}

void add(void)/*���м����������д���*/
{
	//������ͬ�����
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
			/*������ڵ�Ԫ����ȣ�����ӣ�������ŵ�beginpos�У�����secondpos���
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
	//ȥ��0
	/*
	��temp����Ľ����������
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
	srand((unsigned)time(NULL));/*��������������*/
}
void putRandNumber()
{
	int randNum;
	int i,j,count;
	int num[]={2,4};

	randNum = rand() % (sizeof(num)/sizeof(num[0])); //����õ�0��1�±�

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
		case 'w':	//��
			for (i=0; i<SIZE; i++)
			{
				/*��ͬһ��Ԫ���Ƶ�����temp�н��в���*/
				for (j=0; j<SIZE; j++)  //
					temp[j] = code[j][i];
				add();
				/*��������ɺ��temp�����ƶ���ͬһ�и�����
				*/
				for (j=0; j<SIZE; j++) 
					code[j][i] = temp[j];
			}
			move++;
			break;
		case 's':	//��
			
			for (i=0; i<SIZE; i++)
			{
				/*��������ͬһ��Ԫ�ط����ƶ�������temp�н��в���
				*/
				for (j=0; j<SIZE; j++)
					temp[j] = code[SIZE-1-j][i];
				add();
				/*��������ɺ��temp������Ľ�������ƶ���ͬһ�и�����
				*/
				for (j=0; j<SIZE; j++)
					code[SIZE-1-j][i] = temp[j];
			}
			move++;
			break;
		case 'a':	//��
			for (i=0; i<SIZE; i++)
			{
				/*��������ͬһ��Ԫ���ƶ�������temp�н��в���
				*/
				for (j=0; j<SIZE; j++)
					temp[j] = code[i][j];
				add();
				/*���������temp����ƶ���������ͬһ��
				*/
				for (j=0; j<SIZE; j++)
					code[i][j] = temp[j];
			}
			move++;
			break;
		case 'd':	//��
			for (i=0; i<SIZE; i++)
			{
				/*�������е�ͬһ��Ԫ�ط����ƶ���temp�����н��в���
				*/
				for (j=0; j<SIZE; j++)
					temp[j] = code[i][SIZE-1-j];
				add();
				/*���������temp���鷴���ƶ������ӵ�ͬһ����
				*/
				for (j=0; j<SIZE; j++)
					code[i][SIZE-1-j] = temp[j];
			}
			move++;
			break;
		default:
			continue;
		}
		putRandNumber();//�����Ԫ��
		print();//���½����ӡ����Ļ��
	}
}