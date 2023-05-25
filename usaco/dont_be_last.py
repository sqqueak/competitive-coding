# 2017 jan bronze
# 05/2023

import sys

f = open("notlast.in")
N = int(f.readline())
cows = {}
for i in range(N):
    name, amt = f.readline().strip().split(" ")
    if name not in cows:
        cows[name] = int(amt)
    else:
        cows[name] += int(amt)

cows_copy = cows.copy()

for cow in cows:
    if cows_copy[cow] == min(cows.values()):
        cows_copy.pop(cow)

with open("notlast.out", "w") as f:
    sys.stdout = f
    if(len(cows) == 1):
        print(list(cows)[0])
        exit(0)
    
    if(not cows_copy):
       print("Tie")
       exit(0)

    val = min(cows_copy.values())

    l = []
    for cow in cows_copy:
        if cows_copy[cow] == val:
            l.append(cow)
            
    if(len(l) > 1):
        print("Tie")
    else:
        print(l[0])
            