# Advent of Code 2021 - Day 2: Dive!
# 1 December 2021
# 11:48 PM - 11:54 PM

# reading input
f = open('inputs/day2.txt', 'r')
lines = f.readlines()

# part 1
horizontal = depth = 0

for line in lines:
    parsed = line.split(' ')
    if line.__contains__('forward'):
        horizontal += int(parsed[1])
    elif line.__contains__('down'):
        depth += int(parsed[1])
    else:
        depth -= int(parsed[1])

print(horizontal*depth)

# part 2
horizontal = depth = aim = 0

for line in lines:
    parsed = line.split(' ')
    if line.__contains__('forward'):
        horizontal += int(parsed[1])
        depth += aim*int(parsed[1])
    elif line.__contains__('down'):
        aim += int(parsed[1])
    else:
        aim -= int(parsed[1])

print(horizontal*depth)