import itertools

def is_col_empty(grid, col):
    for row in grid:
        if row[col] == "#":
            return False
    return True


def is_row_empty(grid, row):
    pred = lambda x: True if x == "." else False
    return all(pred(i) for i in grid[row]) 


def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    return [list(l) for l in lines]


def solve_l1(input_str):
    grid = parse_input(input_str)
    a_rows = [i for i in range(len(grid)) if is_row_empty(grid, i)]
    a_cols = [j for j in range(len(grid[0])) if is_col_empty(grid, j)]
    
    pos = []
    for i, r in enumerate(grid):
        for j, c in enumerate(r):
            if c == "#":
                pos.append([i, j])

    tot = 0
    for combination in list(itertools.combinations(pos, 2)):
        dist = 0
        sx, sy = combination[0]
        tx, ty = combination[1]

        for v in a_rows:
            if sx <= v <= tx or tx <= v <= sx:
                dist += 1

        for v in a_cols:
            if sy <= v <= ty or ty <= v <= sy:
                dist += 1

        dist += abs(tx - sx) + abs(ty - sy)
        tot += dist

    return tot
        

def solve_l2(input_str):
    grid = parse_input(input_str)
    a_rows = [i for i in range(len(grid)) if is_row_empty(grid, i)]
    a_cols = [j for j in range(len(grid[0])) if is_col_empty(grid, j)]
    
    pos = []
    for i, r in enumerate(grid):
        for j, c in enumerate(r):
            if c == "#":
                pos.append([i, j])

    tot = 0
    for combination in list(itertools.combinations(pos, 2)):
        dist = 0
        sx, sy = combination[0]
        tx, ty = combination[1]

        for v in a_rows:
            if sx <= v <= tx or tx <= v <= sx:
                dist += 999999

        for v in a_cols:
            if sy <= v <= ty or ty <= v <= sy:
                dist += 999999

        dist += abs(tx - sx) + abs(ty - sy)
        tot += dist

    return tot


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
