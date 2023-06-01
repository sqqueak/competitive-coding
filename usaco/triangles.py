# 2020 feb bronze
# 05/2023

import sys

def is_parallel(p1, p2, p3):
    if(p1[0] == p2[0] and p1[1] == p3[1]):
        return (True, 1)
    if(p1[0] == p3[0] and p1[1] == p2[1]):
        return (True, 1)
    if(p2[0] == p1[0] and p2[1] == p3[1]):
        return (True, 2)
    if(p2[0] == p3[0] and p2[1] == p1[1]):
        return (True, 2)
    if(p3[0] == p2[0] and p3[1] == p1[1]):
        return (True, 3)
    if(p3[0] == p1[0] and p3[1] == p2[1]):
        return (True, 3)
    return (False, -1)

with open("triangles.in") as f:
    N = int(f.readline())
    posts = [list(map(int, f.readline().split(" "))) for _ in range(N)]

    max_area = 0
    for i in range(N):
        for j in range(i+1, N):
            for k in range(j+1, N):
                # check parallel
                w = is_parallel(posts[i], posts[j], posts[k])
                if(w[0]):
                    if(w[1] == 1):
                        max_area = max(abs(posts[j][0] - posts[k][0]) * abs(posts[j][1] - posts[k][1]), max_area)
                    elif(w[1] == 2):
                        max_area = max(abs(posts[i][0] - posts[k][0]) * abs(posts[i][1] - posts[k][1]), max_area)
                    else:
                        max_area = max(abs(posts[j][0] - posts[i][0]) * abs(posts[j][1] - posts[i][1]), max_area)

with open("triangles.out", "w") as f:
    sys.stdout = f
    print(max_area)