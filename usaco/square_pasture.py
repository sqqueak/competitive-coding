# 2016 dec bronze
# 05/2023

import sys

f = open("square.in")
abl_x, abl_y, atr_x, atr_y = list(map(int, f.readline().split(" ")))
bbl_x, bbl_y, btr_x, btr_y = list(map(int, f.readline().split(" ")))

# print(min(abl_x,bbl_x), min(abl_y,bbl_y), max(atr_x,btr_x), max(atr_y,btr_y))

with open("square.out", "w") as f:
    sys.stdout = f
    print(max( max(atr_x,btr_x)-min(abl_x,bbl_x), max(atr_y,btr_y)-min(abl_y,bbl_y) )**2)
