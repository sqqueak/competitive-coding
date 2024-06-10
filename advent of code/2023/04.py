# 00:04:00   351  //  00:09:08   260

def parse_input(inp_content):
    return inp_content.strip().split("\n")


def solve_l1(input_str):
    lines = parse_input(input_str)
    net = 0

    for l in lines:
        win = l.split(":")[1].split("|")[0].split(" ")
        pick = l.split(":")[1].split("|")[1].split(" ")

        win = {int(w) for w in win if w}
        pick = [int(w) for w in pick if w]

        cnt = 0
        for n in pick:
            if n in win:
                cnt += 1

        if cnt != 0:
            net += 2 ** (cnt - 1)

    return net


def solve_l2(input_str):
    lines = parse_input(input_str)
    cards = [1] * len(lines)

    for i, l in enumerate(lines):
        win = l.split(":")[1].split("|")[0].split(" ")
        pick = l.split(":")[1].split("|")[1].split(" ")

        win = {int(w) for w in win if w}
        pick = [int(w) for w in pick if w]

        cnt = 0
        for n in pick:
            if n in win:
                cnt += 1

        curr = i + 1
        for j in range(cnt):
            cards[j + curr] += cards[i]

    return sum(cards)


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
