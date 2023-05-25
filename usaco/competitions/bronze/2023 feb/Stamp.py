# dnf

N = int(input())

for _ in range(N):
    input()
    c_size = int(input())
    canvas = [[] for _ in range(c_size)]
    for i in range(c_size):
        canvas[i] = input()

    s_size = int(input())
    stamp = [[] for _ in range(s_size)]
    for i in range(s_size):
        stamp[i] = input().split()

    

    

print(canvas, stamp)