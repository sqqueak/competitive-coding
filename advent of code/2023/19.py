import pprint
import copy

def parse_input(inp_content):
    lines = inp_content.strip().split("\n")
    lines = [l.split("{") for l in lines]
    lines = {l[0]: l[1][:-1].split(",") for l in lines}
    return lines

def validate(letter, op, val, bounds):
    true_bounds = copy.deepcopy(bounds)
    false_bounds = copy.deepcopy(bounds)
    true_bounds[letter].append(f'{letter}{op}{val}')

    if op == ">":
        false_bounds[letter].append(f'{letter}<={val}')
    elif op == "<":
        false_bounds[letter].append(f'{letter}>={val}')
        
    return true_bounds, false_bounds



def solve_l2(input_str):
    rules = parse_input(input_str)
    
    queue = [[rules["qqz"], {"x": [], "m": [], "a": [], "s": []}]]
    final = []

    while queue:
        print("-------")
        branches, bounds = queue.pop()

        for i in range(len(branches) - 1):
            cond, br_true = branches[i].split(":")
            br_false = branches[i + 1]

            letter, op, val = cond[0], cond[1], cond[2:]
            true_bounds, false_bounds = validate(letter, op, val, bounds)

            if len(br_true) > 1:
                if br_true in rules:
                    queue.append([rules[br_true], true_bounds])
                else:
                    bounds = true_bounds
            else:
                final.append([br_true, true_bounds])

            if len(br_false) > 1:
                if br_false in rules:
                    queue.append([rules[br_false], false_bounds])
                else:
                    bounds = false_bounds
            else:
                final.append([br_false, false_bounds])

            print(f'currently testing: {letter} {op} {val}')
            print(f'true : {br_true},  {true_bounds}')
            print(f'false: {br_false}, {false_bounds}')
            print()

    print("======")
    pprint.pprint(final)
    # tot = 0

    # for bound in final:
    #     perms = 1
    #     for key in bound.keys():
    #         if len(bound[key]) == 0:
    #             perms *= 4000
    #         else:
    #             range = 0
    #             for rule in bound[key]:
    #                 if rule[1] == "<":
    #                     pass
    #                 else:
    #                     pass

    #     tot += perms






print(solve_l2(open("in.txt").read()))
