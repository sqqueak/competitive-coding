# 2019 dec bronze
# 05/2023

import sys

f = open("whereami.in")
N = int(f.readline())
s = f.readline().strip()
step = 1

curr = list(set(list(s)))
while(len(curr) != N):
    step += 1
    N -= 1
    curr = []
    for i in range(N):
        curr.append(s[i:i+step])
        # print(s[i:i+step])
    curr = list(set(list(curr)))

with open("whereami.out", "w") as f:
    sys.stdout = f
    print(step)