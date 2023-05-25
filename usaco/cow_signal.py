# 2016 dec bronze
# 05/2023

import sys

f = open("cowsignal.in")

M,N,K = list(map(int, f.readline().split(" ")))
arr = [0] * M

for i in range(M):
    arr[i] = list(f.readline().strip())

with open("cowsignal.out", "w") as f:
    sys.stdout = f

    for i in range(M*K):
        for j in range(N*K):
            orig_row = i//K
            orig_col = j//K

            print(arr[orig_row][orig_col], end="")
        print()

