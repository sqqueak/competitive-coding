# 2016 jan bronze
# 05/2023

import sys

f = open("mowing.in")
N = int(f.readline())
field = [[0 for _ in range(20*N+1)] for __ in range(20*N+1)]
curr_row = 10*N
curr_col = 10*N
instr = []
for i in range(N):
    instr.append(list(f.readline().strip().split(" ")))
    instr[i][1] = int(instr[i][1])

min_x = float('Inf')

total_steps = 0
for l in instr:
    direction = l[0]
    steps = l[1]

    for _ in range(steps):
        if(field[curr_row][curr_col] != 0):
            min_x = min(min_x, total_steps - field[curr_row][curr_col])
        
        field[curr_row][curr_col] = total_steps
        total_steps += 1
        
        if(direction == 'N'):
            curr_row -= 1
        elif(direction == 'S'):
            curr_row += 1
        elif(direction == 'E'):
            curr_col += 1
        else:
            curr_col -= 1    

with open("mowing.out", "w") as f:
    sys.stdout = f
    if(min_x == float('Inf')):
        print(-1)
    else:
        print(min_x)
