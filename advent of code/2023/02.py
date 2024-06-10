# 00:11:19  1661  //  00:14:57  1537

def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    lines = [[c.split(",") for c in l.split(":")[1].split(";")] for l in lines]
    return [[[(int(d.split(" ")[1]), d.split(" ")[2]) for d in c] for c in l] for l in lines]


def solve_l1(input_str):
    lines = parse_input(input_str)
    red, green, blue = 12, 13, 14
    count = 0

    for i, l in enumerate(lines):
        invalid = False
        for item in l:
            for val, col in item:
                if "green" == col and val > green:
                    invalid = True
                    break
                elif "blue" == col and val > blue:
                    invalid = True
                    break
                elif "red" == col and val > red:
                    invalid = True
                    break
            
            if invalid:
                break
        
        if not invalid:
            count += (i+1)
        
    return count


def solve_l2(input_str):
    lines = parse_input(input_str)
    count = 0

    for l in lines:
        g, r, b = 0, 0, 0

        for item in l:
            for val, col in item:
                if "green" == col:
                    g = max(val, g)
                elif "blue" == col:
                    b = max(b, val)
                else:
                    r = max(r, val)
        count += (r * b * g)
                
    return count


print(solve_l1(open("advent of code/2023/in.txt").read()))
print(solve_l2(open("advent of code/2023/in.txt").read()))
