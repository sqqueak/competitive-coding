# 00:06:02   858  //  00:08:49   806

def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    time = lines[0].split(":")[1].split(" ")
    time = [t for t in time if t]

    dist = lines[1].split(":")[1].split(" ")
    dist = [t for t in dist if t]
    return (time, dist)


def solve_l1(input_str):
    time, dist = parse_input(input_str)
    time = [int(t) for t in time]
    dist = [int(t) for t in dist]
    tot = 1

    for i in range(len(time)):
        cnt = 0
        for j in range(time[i]):
            press = j
            run = time[i] - j
            move = run * press
            if move > dist[i]:
                cnt += 1
        tot *= cnt
    
    return tot


def solve_l2(input_str):
    time, dist = parse_input(input_str)
    time, dist = int(''.join(time)), int(''.join(dist))

    tot = 0
    for j in range(time):
        press = j
        run = time - j
        move = run * press
        if move > dist:
            tot += 1
    
    return tot


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
