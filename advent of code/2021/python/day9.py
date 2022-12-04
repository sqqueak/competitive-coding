# Advent of Code 2021 - Day 9: 
# 7 December 2021
# 
# 20 minutes

def isValid(map, row, col):
    if(row < 0 or row >= len(map[0])):
        return False
    if(col < 0 or col >= len(map)):
        return False
    print(col, row)
    return True

# reading input
f = open('inputs/day9.txt', 'r')
lines = f.readlines()

MAP = [ [0]*len(lines[0]) for x in range(len(lines)) ]

counter = 0
for line in lines:
    line = line.rstrip('\n')
    MAP[counter] = list(line)
    counter += 1

minSum = 0

for row in range(len(MAP)):
    for col in range(len(MAP[row])):
        
        print(MAP[row][col], end="")

        # if(isValid(MAP, row, col-1)):
        #     if(not MAP[col][row] < MAP[col-1][row]):
        #         valid = False
        # if(isValid(MAP, row, col+1)):
        #     if(not MAP[col][row] < MAP[col+1][row]):
        #         valid = False
        # if(isValid(MAP, row-1, col-1)):
        #     if(not MAP[col][row] < MAP[col][row-1]):
        #         valid = False
        # if(isValid(MAP, row+1, col)):
        #     if(not MAP[col][row] < MAP[col][row+1]):
        #         valid = False

        # if(valid):
        #     minSum += MAP[row][col]

        # print(minSum)
    print()

