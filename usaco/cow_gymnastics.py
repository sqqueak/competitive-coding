# 2019 dec bronze
# 05/2023

import sys

with open("gymnastics.in", "r") as f:
    K, N = list(map(int, f.readline().split(" ")))
    pairs = {}
    for _ in range(K):
        cows = list(map(int, f.readline().split(" ")))
        for i in range(len(cows)):
            for j in range(i+1,len(cows)):
                if (cows[i], cows[j]) not in pairs:
                    pairs[cows[i], cows[j]] = 1
                else:
                    pairs[cows[i], cows[j]] += 1
            
        count = 0
        for pair in pairs:
            if pairs[pair] == K:
                count += 1

with open("gymnastics.out", "w") as f:
    sys.stdout = f
    print(count)