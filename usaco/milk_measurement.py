# 2017 dec bronze
# 05/2023

import sys

f = open("measurement.in")
N = int(f.readline())
measures = [0] * N
for i in range(N):
    measures[i] = list(f.readline().strip().split(" "))
    measures[i][0] = int(measures[i][0])

# Bessie, Elsie, Mildred
cows = [7,7,7]

changes = 0
measures = sorted(measures, key=lambda x: x[0])

for m in measures:
    displayed = [i for i in range(3) if cows[i] == max(cows)]
    cow = m[1]
    if(cow == 'Bessie'):
        if(m[2][0] == '+'):
            cows[0] += int(m[2][1])
        else:
            cows[0] -= int(m[2][1])
    elif(cow == 'Elsie'):
        if(m[2][0] == '+'):
            cows[1] += int(m[2][1])
        else:
            cows[1] -= int(m[2][1])
    else:
        if(m[2][0] == '+'):
            cows[2] += int(m[2][1])
        else:
            cows[2] -= int(m[2][1])
    
    new_displayed = [i for i in range(3) if cows[i] == max(cows)]
    if(new_displayed != displayed):
        changes += 1
    displayed = new_displayed


with open("measurement.out", "w") as f:
    sys.stdout = f
    print(changes)
