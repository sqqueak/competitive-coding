#  2023 may 25

n, x = list(map(int, input().split(" ")))
a = list(map(int, input().split(" ")))

if(min(a) > x or len(a) == 1):
    print("IMPOSSIBLE")
    exit(0)

arr = {}
for i in range(n):
    arr[i] = a[i]

a = sorted(a)
p1 = 0
p2 = len(a)-1
res = a[p1] + a[p2]

while(p1 < p2 and res != x):
    if(res > x):
        p2 -= 1
    else:
        p1 += 1
    res = a[p1] + a[p2]

if(res == x and p1 != p2):
    vals = [a[p1], a[p2]]
    for k in arr.keys():
        if(arr[k] in vals):
            print(k+1, end=" ")
            vals.remove(arr[k])
        if(not vals):
            break
    print()
else:
    print("IMPOSSIBLE")
