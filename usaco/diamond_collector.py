# 2015 dec bronze
# 05/2023

import sys

with open("diamond.in") as f:
    N, K = list(map(int, f.readline().split(" ")))
    diamonds = [int(f.readline()) for _ in range(N)]
    max_display = 0

    for x in list(set(list(diamonds))): 
        display = 0
        for d in diamonds:
            if(x <= d <= x+K):
                display += 1
        max_display = max(max_display, display)


with open("diamond.out", "w") as f:
    sys.stdout = f
    print(max_display)