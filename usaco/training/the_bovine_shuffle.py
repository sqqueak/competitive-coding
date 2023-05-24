# 2017 dec bronze
# 05/2023

# ideal O(N)

import sys

f = open("shuffle.in")
N = int(f.readline())
pos = list(map(int, f.readline().split(" ")))
ids = list(map(int, f.readline().split(" ")))

for _ in range(3):
    new_ids = ids.copy()
    for i in range(N):
        new_ids[i] = ids[pos[i]-1]
    ids = new_ids

with open("shuffle.out", "w") as f:
    sys.stdout = f
    for i in ids:
        print(i)
