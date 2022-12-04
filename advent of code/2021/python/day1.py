# Advent of Code 2021 - Day 1: Sonar Sweep
# 1 December 2021
# 4:25 PM - 5:27 PM, on off at work

# reading input
f = open('inputs/day1.txt', 'r')
lines = f.readlines()

# part 1
counter = index = 0

for line in lines:

    if(index != 0):
        current = line.rstrip()
        previous = (lines.__getitem__(index-1)).rstrip()    

        if(int(current) > int(previous)): 
            counter += 1
    index += 1

print(counter) # part 1 answer

# part 2
sums = []

for i in range(lines.__len__()-2):
    sums.append(int((lines.__getitem__(i)).rstrip()) + 
                int((lines.__getitem__(i+1)).rstrip()) + 
                int((lines.__getitem__(i+2)).rstrip()))

counter = index = 0

for sum in sums:

    if(index != 0):
        current = sum
        previous = sums.__getitem__(index-1)

        if(int(current) > int(previous)): 
            counter += 1
    index += 1

print(counter) # part 2 answer