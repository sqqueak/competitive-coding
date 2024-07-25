from collections import defaultdict
import math
import pprint

def parse_input(inp_content):
    lines = inp_content.strip().split("\n")    
    return [l.split(": ") for l in lines]


def solve_l1(input_str):
    instrs = parse_input(input_str)

    pprint.pprint(instrs)

def solve_l2(input_str):
    pass

print(solve_l1(open("in.txt").read()))
# print(solve_l2(open("in.txt").read()))
