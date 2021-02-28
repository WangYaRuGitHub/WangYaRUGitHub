#include<iostream>
using namespace std;
class Date
{
public:
	Date(){}
	Date(int y,int m,int d):m_year(y),m_month(m),m_day(d){}
	void Print()
	{
		cout<<m_year<<"/"<<m_month<<"/"<<m_day<<endl;
	}
	~Date(){}
private:
	int m_year;
	int m_month;
	int m_day;
};
void main()
{
	Date t(2019,10,24);
	t.Print();
}
