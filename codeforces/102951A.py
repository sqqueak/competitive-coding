N = int(input())
x = list(map(int, input().split(" ")))
y = list(map(int, input().split(" ")))
max_square = 0

for i in range(N):
    for j in range(i+1, N):
        max_square = max(max_square, (x[j]-x[i])**2 + (y[j]-y[i])**2)

print(max_square)