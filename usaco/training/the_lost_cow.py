# 2017 open bronze
# 05/2023

import sys

f = open("lostcow.in")
x,y = list(map(int, f.readline().split(" ")))
d = 0
c = 0
p = x

if(x > y):
    while(p > y):
        if(c%2 == 0):
            d += abs(p - x - 2**c)
            p = x + 2**c
        else:
            d += abs(p - x + 2**c)
            p = x - 2**c

        c += 1
        print(p, d)

    while(p < y):
        p += 1
        d -= 1

elif(x < y):
    while(p < y):
        if(c%2 == 0):
            d += abs(p - x - 2**c)
            p = x + 2**c
        else:
            d += abs(p - x + 2**c)
            p = x - 2**c

        c += 1
        print(p, d)

    while(p > y):
        p -= 1
        d -= 1

else:
    pass

with open("lostcow.out", "w") as f:
    sys.stdout = f
    print(d)
