from collections import defaultdict

def hash(s):
    curr = 0
    for ch in s:
        curr += ord(ch)
        curr *= 17
        curr %= 256
    return curr


def parse_input(inp_content):
    return inp_content.strip().split(",")


def solve_l1(input_str):
    return sum([hash(e) for e in parse_input(input_str)])


def solve_l2(input_str):
    elts = parse_input(input_str)
    boxes = defaultdict(list)

    for e in elts:
        if "=" in e:
            label, num = e.split("=")
            box = hash(label)
            found = False
            
            for i, r in enumerate(boxes[box]):
                if label in r:
                    found = True
                    boxes[box][i] = f'{label} {num}'
                    break

            if not found:
                boxes[box].append(f'{label} {num}')

        elif "-" in e:
            label = e.split("-")[0]
            box = hash(label)

            for r in boxes[box]:
                if label in r:
                    boxes[box].remove(r)

    tot = 0
    for box in sorted(boxes.keys()):
        for i, lens in enumerate(boxes[box]):
            tot += (box + 1) * (i + 1) * int(lens[-1])
    
    return tot


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
