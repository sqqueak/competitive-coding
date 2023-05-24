# 2018 dec bronze
# 05/2023

# non-ideal O(NT), T largest ending time

import sys

f = open("blist.in")
N = int(f.readline())
s = [0] * N
t = [0] * N
b = [0] * N
max_buckets = 0

for i in range(N):
    s[i], t[i], b[i] = list(map(int, f.readline().split(" ")))

for i in range(1, max(t)+1):
    B = 0
    for cow in range(N):
        if(s[cow] <= i <= t[cow]):
            B += b[cow]
    max_buckets = max(max_buckets, B)

with open("blist.out", "w") as f:
    sys.stdout = f
    print(max_buckets)
