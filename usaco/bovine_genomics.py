# 2015 dec bronze
# 05/2023

import sys

with open("cownomics.in") as f:
    N, M = list(map(int, f.readline().split(" ")))
    spotty = [f.readline() for _ in range(N)]
    plain = [f.readline() for _ in range(N)]

    spotty_genes = [list(set([spotty[j][i] for j in range(N)])) for i in range(M)]
    plain_genes = [list(set([plain[j][i] for j in range(N)])) for i in range(M)]

    count = 0
    for i in range(M):
        if(len(spotty_genes[i]) + len(plain_genes[i]) == len(list(set(spotty_genes[i] + plain_genes[i])))):
            count += 1

with open("cownomics.out", "w") as f:
    sys.stdout = f
    print(count)