n, t = list(map(int, input().split(" ")))
books = list(map(int, input().split(" ")))

if(min(books) > t):
    print(0)
    exit(0)

j = 0
curr_sum = 0
count = 0
best = 0

for i in range(n):
    while(curr_sum < t and j < len(books)):
        curr_sum += books[j]
        count += 1
        j += 1

    while(curr_sum > t and j >= 0):
        j -= 1
        curr_sum -= books[j]
        count -= 1

    best = max(count, best)

    if(j == n):
        break

    curr_sum -= books[i]
    count -= 1
    if(j+1 < len(books)):
        curr_sum += books[j]
        j += 1
        count += 1
    
print(best)