from collections import deque


def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    return [list(l) for l in lines]


def solve_l1(input_str):
    grid = parse_input(input_str)
    queue = deque([])

    for i, r in enumerate(grid):
        for j, c in enumerate(r):
            if grid[i][j] == "S":
                queue.append([i,j, 0])
                grid[i][j] = "."
    
    steps = 6
    cnt = 0
    while queue:
        x,y,d = queue.popleft()
        if d > steps:
            continue
        if grid[x][y] == "." or grid[x][y] == "S":
            for dx, dy in [[0,1],[0,-1],[1,0],[-1,0]]:
                if 0 <= x + dx < len(grid) and 0 <= y + dy < len(grid[0]):
                    queue.append([x + dx, y + dy, d + 1])
            grid[x][y] = ","

        if (d % steps == 0 or (d % 2 == steps % 2)) and grid[x][y] == ",":
            grid[x][y] = "O"
            cnt += 1

            print(d, ":", x, y)

    return cnt



def solve_l2(input_str):
    pass

print(solve_l1(open("in.txt").read()))
# print(solve_l2(open("advent of code/2023/in.txt").read()))
