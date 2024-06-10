# 00:05:03  2112  //  00:21:11  1920

import re

def parse_input(inp_content):
    return inp_content.strip().split("\n")


def solve_l1(input_str):
    lines = parse_input(input_str)
    n = []
    for l in lines:
        x = re.sub("[^0-9]", "", l)
        n.append(''.join([x[0],x[-1]]))
    return sum([int(x) for x in n])


def solve_l2(input_str):
    lines = parse_input(input_str)
    d = {"one":1, "two":2, "three":3, "four":4, "five":5, "six":6, "seven":7, "eight":8, "nine":9, "zero":0}
    ns = {"0","1","2","3","4","5","6","7","8","9"}
    ws = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"}
    s = 0

    for l in lines:
        front = None
        for i,c in enumerate(l):
            if c in ns:
                front = int(c)
            else:
                for word in ws:
                    if l[i:min(len(l), i+len(word))] == word:
                        front = d[word]
                        break
            if front:
                break

        back = None
        for i,c in enumerate(l[::-1]):
            if c in ns:
                back = int(c)
            else:
                for word in ws:
                    if l[len(l)-i-len(word) : len(l)-i] == word:
                        back = d[word]
                        break
            if back:
                break
        
        s += (int(f'{front}{back}'))                   
            
    return s


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))