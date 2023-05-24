# 2016 feb bronze
# 05/2023

# O(N^2)

import sys

f = open("cbarn.in")
N = int(f.readline())
cows = [0] * N
mult = [0] * (2 * N)
min_dist = float('Inf')

for i in range(N):
    cows[i] = int(f.readline())
    mult[i] = i
    mult[i+N] = i

for i in range(N):
    s = 0
    for a,b in zip(cows, mult[i:i+N]):
        s += a*b
    min_dist = min(min_dist, s)

with open("cbarn.out", "w") as f:
    sys.stdout = f
    print(min_dist)
