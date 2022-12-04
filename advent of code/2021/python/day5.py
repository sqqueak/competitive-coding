# Advent of Code 2021 - Day 5: Hydrothermal Venture
# 5 December 2021
# 
# don't use [[v]*n]*n
# use [[v]*n for x in range(n)]
# also only includes part 2

def fillInBoard(board, row1, col1, row2, col2):
    print(row1, col1, row2, col2)

    if(row1 == row2): # horizontal
        startCol = min(col1, col2)
        endCol = max(col1, col2)
        row = row1

        for i in range(startCol, endCol+1, 1):
            board[row][i] += 1

        return board

    elif(col1 == col2): # vertical
        startRow = min(row1, row2)
        endRow = max(row1, row2)
        col = col1

        for i in range(startRow, endRow+1, 1):
            print(i, col)
            board[i][col] += 1

            for a in board:
                print(a)
            print()
    
        return board
    
    else: # diagonal
        if(row1 < row2 and col1 < col2 or row1 > row2 and col1 > col2): # top left to bottom right
            startRow = min(row1, row2)
            endRow = max(row1, row2)
            currCol = min(col1, col2)

            for i in range(startRow, endRow+1, 1):
                board[i][currCol] += 1
                currCol += 1
        
            return board

        elif(row1 < row2 and col1 > col2 or row1 > row2 and col1 < col2):
            startCol = min(col1, col2)
            endCol = max(col1, col2)
            currRow = max(row1, row2)

            for i in range(startCol, endCol+1, 1):
                board[currRow][i] += 1
                currRow -= 1

            return board

        else: print("STOP")
    
# reading input
f = open('inputs/day5.txt', 'r')
lines = f.readlines()

starts = []
ends = []

for line in lines:
    line = line.rstrip().split(" -> ")
    starts.append(line[0].split(",")) # string form
    ends.append(line[1].split(","))

BOARD = [ [0]*10 for x in range(10) ] # makes empty 999x999 array
print(BOARD)

for i in range(len(lines)):
    start = starts.pop(0)
    end = ends.pop(0)

    row1 = int(start[0])
    col1 = int(start[1])
    row2 = int(end[0])
    col2 = int(end[1])

    BOARD = fillInBoard(BOARD, row1, col1, row2, col2)  
    # print(BOARD)

overlap = 0

# b = fillInBoard( ( [0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],
#                     [0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],
#                     [0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],
#                     [0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0],
#                     [0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0]), 0,9,5,9 )

# print()
# for a in BOARD:
#     print(a)

# print()

# for a in b:
#     print(a)

for row in BOARD:
    for cell in row:
        if(cell >= 2):
            overlap += 1

print(overlap)