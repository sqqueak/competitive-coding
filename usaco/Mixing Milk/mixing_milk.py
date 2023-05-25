# 2018 dec bronze
# 05/2023

import sys

f = open("mixmilk.in")

c = [0] * 3
m = [0] * 3
for i in range(3):
    c[i], m[i] = list(map(int, f.readline().split(" ")))

for i in range(100):
    cur = i%3
    nxt = (i+1)%3

    p = min(c[nxt]-m[nxt], m[cur])
    m[cur] -= p
    m[nxt] += p


with open("mixmilk.out", "w") as f:
    sys.stdout = f
    for i in m:
        print(i)
