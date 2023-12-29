from collections import deque

R, C, N = list(map(int, input().split(" ")))
grid = [[False for _ in range(C)] for _ in range(R)]
coords = deque()
for i in range(N):
    coords.append(list(map(int, input().split(" "))) + [1])
time = 1
hit = 0

while coords:
    x, y, t = coords.popleft()
    if not grid[x - 1][y - 1]:
        grid[x - 1][y - 1] = True
        time = t
        hit += 1

        for dx, dy in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
            if 0 < dx + x <= R and 0 < dy + y <= C and not grid[dx + x - 1][dy + y - 1]:
                coords.append([dx + x, dy + y, t + 1])

        if hit == R * C:
            break

print(time)