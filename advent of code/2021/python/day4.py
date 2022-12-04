# Advent of Code 2021 - Day 3: Binary Diagnostic
# 4 December 2021
# 12:12 PM - 12:19 PM (checkForWin)
# 12:40 PM - 1:10 PM
# 3:54 PM - 4:25

import re

def checkForWin(board):
    # checking rows
    for row in range(len(board)):
        if(board[row][0] == board[row][1] and
                board[row][0] == board[row][2] and
                board[row][0] == board[row][3] and
                board[row][0] == board[row][4]):
            return True
    
    for col in range(len(board[0])):
        if(board[0][col] == board[1][col] and 
                board[0][col] == board[2][col] and 
                board[0][col] == board[3][col] and 
                board[0][col] == board[4][col]):
            return True
    
    return False

def checkIfBoardHasNumber(board, number):
    for row in range(len(board)):
        for col in range(len(board[0])):
            if board[row][col] == number:
                board[row][col] = 100
                return True
    return False

def changeIfBoardHasNumber(board, number):
    for row in range(len(board)):
        for col in range(len(board[0])):
            if board[row][col] == number:
                board[row][col] = 100
                return board
    
# reading input
f = open('inputs/day4.txt', 'r')
lines = f.readlines()

numsCalled = lines.pop(0).rstrip().split(",")

for num in numsCalled: # changing all to int type
    num = int(num)

boards = []

while(len(lines) > 0):
    currLine = lines.pop(0).rstrip()

    currBoard = [[]*5 for x in range(5)] # makes an empty, two dimensional, 5x5 array

    if(currLine):
        for i in range(5):

            currCol = []

            colTemp = re.split( "\\s\\s|\\s", currLine)
            for val in colTemp:
                if(str(val)):
                    currCol.append(int(val))

            currBoard[i] = currCol
            if(len(lines) > 0): currLine = lines.pop(0)
        
        boards.append(currBoard)

# for board in boards:
#     for row in board:
#         for col in row:
#             print(col, end=" ")
        
#         print()
#     print()

# part 1

pickedNums = {}
winningBoard = None

while(winningBoard == None):
    currBingoNum = numsCalled.pop(0)
    #print(currBingoNum)

    for board in boards:

        print(board, currBingoNum)
        #print(checkIfBoardHasNumber(board, int(currBingoNum))) # somehow currBingoNum not an int?

        # ic ant get this code to fucking work

        # cannot hash immutable objects because its address changes when an item is added or removed

        if(checkIfBoardHasNumber(board, int(currBingoNum))):
            print("TRUE")


            currPicked = str(pickedNums[board])
            currPicked += str(currBingoNum, " ")
            pickedNums[board] = str(currPicked)
            board = changeIfBoardHasNumber(board, currBingoNum)
        
        # print(board)
        if(checkForWin(board)):
            winningBoard = board
            break

#print(checkIfBoardHasNumber([[30, 61, 64, 54, 80], [22, 47, 84, 16, 8], [83, 18, 65, 70, 11], [81, 23, 98, 26, 82], [45, 69, 6, 53, 68]], 70))
