# 01:02:09  7096  //  01:05:40  4808
# accidentally fell asleep

def get_num(grid, x, y):
    num = []
    while y >= 0 and grid[x][y] in {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}:
        y -= 1
    y += 1
    while y < len(grid[0]) and grid[x][y] in {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}:
        num.append(grid[x][y])
        grid[x][y] = "M"
        y += 1
    return int(''.join(num))


def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    return [list(l) for l in lines]


def solve_l1(input_str):
    grid = parse_input(input_str)
    s = 0

    for i, l in enumerate(grid):
        for j, ch in enumerate(l):
            if ch not in {".", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "M"}:
                for dx, dy in [[-1, -1],[-1, 0],[-1, 1],[0, -1],[0,1],[1, -1],[1, 0],[1, 1]]:
                    if grid[i + dx][j + dy] in {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}:
                        if 0 <= i + dx < len(grid) and 0 <= j + dy < len(grid[0]):
                            s += get_num(grid, i + dx, j + dy)
    return s


def solve_l2(input_str):
    grid = parse_input(input_str)
    s = 0

    for i, l in enumerate(grid):
        for j, ch in enumerate(l):
            if ch == "*":
                ns = 0
                v = 1
                for dx, dy in [[-1, -1],[-1, 0],[-1, 1],[0, -1],[0,1],[1, -1],[1, 0],[1, 1]]:
                    if grid[i + dx][j + dy] in {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}:
                        if 0 <= i + dx < len(grid) and 0 <= j + dy < len(grid[0]):
                            v *= get_num(grid, i + dx, j + dy)
                            ns += 1

                if ns == 2:
                    s += v
    return s


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
