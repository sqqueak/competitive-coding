# 2017 dec bronze
# 05/2023

import sys

def intersection_area(s1, s2) -> int:
    width = min(s1[2],s2[2])-max(s1[0],s2[0])
    length = min(s1[3],s2[3])-max(s1[1],s2[1])
    if(width < 0 or length < 0):
        return 0
    return width*length

f = open("billboard.in")
b1 = list(map(int, f.readline().split(" ")))
b2 = list(map(int, f.readline().split(" ")))
t = list(map(int, f.readline().split(" ")))

# blx bly trx try
union = ((b1[3]-b1[1]) * (b1[2]-b1[0])) + ((b2[3]-b2[1]) * (b2[2]-b2[0]))

with open("billboard.out", "w") as f:
    sys.stdout = f
    print(union - intersection_area(b1,t) - intersection_area(b2,t))
