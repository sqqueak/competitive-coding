# 00:09:04  1026  //  00:15:26  1578

def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    for i, l in enumerate(lines):
        lines[i] = list(map(int, l.split(" ")))
    return lines


def iterate(l):
    nxt = []
    for low, high in zip(l, l[1:]):
        nxt.append(high - low)
    return nxt


def solve_l1(input_str):
    lines = parse_input(input_str)
    tot = 0

    for nums in lines:
        history = [nums]
        m = iterate(nums)
        
        while any(x != 0 for x in m):
            history.append(m)
            m = iterate(m)
        history.append(m)

        ongoing = 0
        for h in history[::-1]:
            ongoing += h[-1]
        tot += ongoing

    return tot


def solve_l2(input_str):
    lines = parse_input(input_str)
    tot = 0

    for nums in lines:
        history = [nums]
        m = iterate(nums)

        while any(x != 0 for x in m):
            history.append(m)
            m = iterate(m)
        history.append(m)

        ongoing = 0
        for h in history[::-1]:
            ongoing = h[0] - ongoing
        tot += ongoing

    return tot


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
