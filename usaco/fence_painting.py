# 2015 dec bronze
# 05/2023

# can be better, turn into a union-intersection solution
# this still runs in O(1)

import sys

f = open("paint.in")
a, b = list(map(int, f.readline().split(" ")))
c, d = list(map(int, f.readline().split(" ")))
res = 0

if(b <= c or d <= a):
    res = abs(a-b) + abs(c-d)
elif(c <= b or a <= d):
    res = abs(a-b) + abs(c-d) - abs(max(a,c) - min(b,d))
else:
    res = abs(max(d,b) - min(c,a))

with open("paint.out", "w") as f:
    sys.stdout = f
    print(res)
