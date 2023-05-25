# 2018 open bronze
# 05/2023

# O(1)

import sys

f = open("tttt.in")
board = [0] * 3
solo_wins = []
duo_wins = []

for i in range(3):
    board[i] = list(f.readline().strip())

arrs = []
arrs.append([board[0][0], board[1][1], board[2][2]])
arrs.append([board[0][2], board[1][1], board[2][0]])
for i in range(3):
    arrs.append(board[i])
    arrs.append([board[0][i], board[1][i], board[2][i]])

for arr in arrs:
    if(len(set(arr)) == 1):
        if(arr[0] not in solo_wins):
            solo_wins.append(arr[0])
    elif(len(set(arr)) == 2):
        duo = list(set(arr))
        if(duo not in duo_wins and reversed(duo) not in duo_wins):
            duo_wins.append(duo)

print(arrs)

with open("tttt.out", "w") as f:
    sys.stdout = f
    print(len(solo_wins))
    print(len(duo_wins))

