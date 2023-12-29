# 00:06:08   746  //  00:17:47   513

from collections import defaultdict
import math

def parse_input(inp_content):
    lines = inp_content.strip().split("\n")

    instrs = defaultdict()
    for l in lines[2:]:
        k, v = l.split(" = ")
        instrs[k] = [v[1:4], v[6:9]]
    
    return (lines[0], instrs)


def solve_l1(input_str):
    lr, instrs = parse_input(input_str)

    curr = "AAA"
    steps, ptr = 0, 0
    while curr != "ZZZ":
        steps += 1
        
        if lr[ptr] == "L":
            curr = instrs[curr][0]
        else:
            curr = instrs[curr][1]

        ptr = (ptr + 1) % len(lr)

    return steps


def solve_l2(input_str):
    lr, instrs = parse_input(input_str)

    currs = []
    for key in instrs.keys():
        if key[-1] == "A":
            currs.append(key)

    steps, ptr = 0, 0
    vals = []
    while currs:
        steps += 1
        newcurrs = []

        for curr in currs:
            if lr[ptr] == "L":
                curr = instrs[curr][0]
            else:
                curr = instrs[curr][1]

            if curr[-1] == "Z":
                vals.append(steps)
            else:
                newcurrs.append(curr)
        
        currs = newcurrs
        ptr = (ptr + 1) % len(lr)

    return math.lcm(*vals)


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
