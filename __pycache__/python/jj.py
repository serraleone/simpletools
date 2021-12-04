def whi1(i):
    if i < 6:
        num.append(i)
        i += 1
        whi1(i)
    else:
        print(num)

num = []
a = 0
whi1(a)    