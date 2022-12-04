with open("2022/1.txt","r") as f:
    data = f.read()

def parse(c):
    return [[int(j) for j in i.split("\n")] for i in c.split("\n\n")]

def p1(d):
    data = parse(d)

    return max([sum(i) for i in data])

def p2(d):
    data = parse(d)

    elf = [sum(i) for i in data]
    elf.sort()
    return sum(elf[len(elf)-3:])

print(p1(data))
print(p2(data))