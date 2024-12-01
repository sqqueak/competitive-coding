from collections import deque

def simulate(start, grid, writer):
    queue = deque([start])
    cache = set()

    while queue:
        x, y, d = queue.popleft()
        if not (0 <= x < len(grid) and 0 <= y < len(grid[0])) or (x, y, d) in cache:
            continue

        cache.add((x, y, d))

        if d == "r":
            while y < len(grid[0]) - 1 and grid[x][y] == ".":
                writer[x][y] = "#"
                y += 1

            if grid[x][y] == "|":
                queue.append([x - 1, y, "u"])
                queue.append([x + 1, y, "d"])
            elif grid[x][y] == "-":
                queue.append([x, y + 1, "r"])
            elif grid[x][y] == "\\":
                queue.append([x + 1, y, "d"])
            elif grid[x][y] == "/":
                queue.append([x - 1, y, "u"])

        elif d == "d":
            while x < len(grid) - 1 and grid[x][y] == ".":
                writer[x][y] = "#"
                x += 1

            if grid[x][y] == "|":
                queue.append([x + 1, y, "d"])
            elif grid[x][y] == "-":
                queue.append([x, y + 1, "r"])
                queue.append([x, y - 1, "l"])
            elif grid[x][y] == "\\":
                queue.append([x, y + 1, "r"])
            elif grid[x][y] == "/":
                queue.append([x, y - 1, "l"])
 
        elif d == "u":
            while 0 < x and grid[x][y] == ".":
                writer[x][y] = "#"
                x -= 1

            if grid[x][y] == "|":
                queue.append([x - 1, y, "u"])
            elif grid[x][y] == "-":
                queue.append([x, y + 1, "r"])
                queue.append([x, y - 1, "l"])
            elif grid[x][y] == "\\":
                queue.append([x, y - 1, "l"])
            elif grid[x][y] == "/":
                queue.append([x, y + 1, "r"])

        elif d == "l":
            while 0 < y and grid[x][y] == ".":
                writer[x][y] = "#"
                y -= 1

            if grid[x][y] == "|":
                queue.append([x - 1, y, "u"])
                queue.append([x + 1, y, "d"])
            elif grid[x][y] == "-":
                queue.append([x, y - 1, "l"])
            elif grid[x][y] == "\\":
                queue.append([x - 1, y, "u"])
            elif grid[x][y] == "/":
                queue.append([x + 1, y, "d"])

        writer[x][y] = "#"

    c = 0
    for row in writer:
        for cell in row:
            if cell == "#":
                c += 1
    return c


def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    return [list(l) for l in lines]


def solve_l1(input_str):
    return simulate([0, 0, "r"], parse_input(input_str), parse_input(input_str))


def solve_l2(input_str):
    grid = parse_input(input_str)

    res = 0
    for i in range(len(grid)):
        res = max(res, simulate([i, 0, "r"], grid, parse_input(input_str)))
        res = max(res, simulate([i, len(grid[0]) - 1, "l"], grid, parse_input(input_str)))
    for i in range(len(grid[0])):
        res = max(res, simulate([0, i, "d"], grid, parse_input(input_str)))
        res = max(res, simulate([len(grid) - 1, i, "u"], grid, parse_input(input_str)))
    return res


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
