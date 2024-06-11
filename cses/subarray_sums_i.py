#  2023 may 25

import time


t = time.time()

n, x = list(map(int, input().split(" ")))
arr = list(map(int, input().split(" ")))

if(min(arr) > x):
    print(0)
    exit(0)

p2 = 0
count = 0
curr_sum = 0

for p1 in range(len(arr)):
    while(curr_sum < x and p2 < len(arr) and p2+1 < len(arr)+1):
        curr_sum += arr[p2]
        p2 += 1

    while(curr_sum > x and p2 >= 0 and p2-1 > p1):
        p2 -= 1
        curr_sum -= arr[p2]

    # print(curr_sum)

    if(curr_sum == x):
        count += 1
        # print(arr[p1:p2])
        
    
    curr_sum -= arr[p1]
    # print(curr_sum)

    if(p2 == len(arr)-1 or p2 == len(arr)):
        pass
    else:
        curr_sum += arr[p2]
        p2 += 1
    
    # print(curr_sum)
    # print("------", p1,p2)
    # print()


print(count)
# print(time.time() - t)