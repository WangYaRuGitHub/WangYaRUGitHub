while(1):
    m =eval( input("请输入一个正整数:"))
    i = 0
    a = 0
    for i in range(0,m+1):
        if i > 3:
            if i % 2 == 0 or i % 3== 0:
                i = i + 1
                a = a + 1
    print("合数数量：{}".format(a))
       
    

