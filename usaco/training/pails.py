import math
import sys

sys.stdin = open("pails.in");

X, Y, M = map(int, input().split(" "))

opt = []

for i in range(math.ceil(M/X)+1):
    if(X*i > M):
        continue

    for j in range(math.ceil(M/Y)+1):
        if(X*i + Y*j > M):
            continue
        
        opt.append(X*i + Y*j)




with open("pails.out", "w") as f:
    sys.stdout = f
    print(max([i for i in opt if i <= M]))