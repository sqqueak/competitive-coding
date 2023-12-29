from collections import defaultdict
from collections import deque

N, M = list(map(int, input().split(" ")))
items = list(map(int, input().split(" ")))
ins = defaultdict(list)
outs = defaultdict(list)
indegrees = defaultdict(lambda: 0)

for i in range(M):
    mat, prod, num = list(map(int, input().split(" ")))
    ins[prod].append([mat, num])
    outs[mat].append([prod, num])
    indegrees[mat] += 1

topo = []
Q = deque([i for i in range(N) if indegrees[i] == 0])

while Q:
    curr = Q.popleft()
    for child in ins[curr]:
        indegrees[child[0]] -= 1
        if indegrees[child[0]] == 0:
            Q.append(child[0])
    topo.append(curr)

for n in topo[1:]:
    for pre in outs[n]:
        items[n] += items[pre[0]] * pre[1]

for item in items:
    print(item, end=" ")
