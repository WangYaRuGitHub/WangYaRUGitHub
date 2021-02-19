import requests
from bs4 import BeautifulSoup
import re
import json
import sys
from PyQt5.QtWidgets import *
#函数部分
def getKeyWordResult(keyword):
    url='http://www.baidu.com/s?wd='+keyword
    try:
        r=requests.get(url,timeout=50)
        r.raise_for_status()
        r.encoding='utf-8'
        return r.text
    except:
        return ""
def parserLinks(html):
    soup=BeautifulSoup(html,"html.parser")
    links=[]
    for div in soup.find_all('div',{'data-tools':re.compile('url')}):
        data=div.attrs['data-tools']
        d=json.loads(data)
        links.append(d['url'])
    return links
def getHTML(url):
    try:
        r = requests.get(url,timeout=30)

        r.raise_for_status()

        r.encoding = r.apparent_encoding

        return r.text

    except:

        return ""
def getContent(url):

    html = getHTML(url)

    soup = BeautifulSoup(html,'html.parser')

    title = soup.select('div.mbtitle')

    paras_tmp = soup.select('p')

    paras = paras_tmp[3:]

    return paras

#主程序代码
def login():
    str=Line1.text()
    html=getKeyWordResult(str)
    ls=parserLinks(html)
    file=open('{}.txt'.format(str),'w',encoding='utf-8')
    for i in ls:
        word=getContent(i)
        for j in word:
            if j.string:
                print(j.string)
                file.write(j.string+'\n')
    file.close()
    QMessageBox.information(Window,"网络爬虫客户端",'{:*^69}'.format('已完成爬取，请打开   {}.txt  查看!'.format(str)))
app=QApplication(sys.argv)
Window=QWidget()
Window.setGeometry(400,200,600,400)
Window.setWindowTitle("网络爬虫客户端")

Lab1=QLabel("关键词",Window)
Lab1.setGeometry(100,50,60,30)
Lab1.setStyleSheet("font-size:20px")
Line1=QLineEdit(Window)
Line1.setGeometry(170,50,200,30)


Button=QPushButton("搜索",Window)
Button.setGeometry(170,100,200,30)

Button.clicked.connect(login)

Window.show()
sys.exit(app.exec_())
