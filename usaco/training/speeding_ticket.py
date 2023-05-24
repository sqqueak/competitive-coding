# 2015 dec bronze
# 05/2023

# O(M+N)

import sys

f = open("speeding.in")

lim = [0] * 100
bes = [0] * 100

N,M = list(map(int, f.readline().split(" ")))
p = 0

for i in range(N):
    l,s = list(map(int, f.readline().split(" ")))
    for i in range(p,l+p):
        lim[i] = s
    p += l

p = 0
for i in range(M):
    l,s = list(map(int, f.readline().split(" ")))
    for i in range(p,l+p):
        bes[i] = s
    p += l

with open("speeding.out", "w") as f:
    sys.stdout = f
    m = 0
    for (l,b) in zip(lim, bes):
        m = max(b-l, m)

    print(m)
