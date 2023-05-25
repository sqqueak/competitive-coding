N = int(input())
flowers = list(map(int, input().split(" ")))
COUNT = 0

for n in range(N,0,-1):
    i = 0
    size = n

    while(i+size <= N):
        # print([f for f in range(len(flowers)) if f>=i and f<i+size])
        # print(i, i+size)

        photo = [flowers[f] for f in range(len(flowers)) if f>=i and f<i+size]

        # print(sum(photo)/len(photo))
        # print(photo)
        if(sum(photo)/len(photo) in photo):
            COUNT += 1

        i += 1

print(COUNT)