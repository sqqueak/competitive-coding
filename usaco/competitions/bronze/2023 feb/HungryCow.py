N, T = map(int, input().split(" "))
eaten = 0
day = 1

for n in range(N):
    d, n = map(int, input().split(" "))

    if(d+n-1 > T):
        eaten += T-d+1
        break
    else:
        eaten += n
        day = d+n-1

print(eaten)