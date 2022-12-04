# Advent of Code 2021 - Day 6: Lanternfish
# 7 December 2021
# 
# 20 minutes, part 1 and 2 are similar except for 80 to 256

# reading input
f = open('inputs/day6.txt', 'r')
lines = f.readlines()

lines = lines.pop().rstrip().split(",")

# part 1
fishes = [0]*9

for fish in lines:
    fishes[int(fish)] += 1 # lines is a string array still

for i in range(80):
    pregnantFishes = fishes[0]

    for j in range(8):
        fishes[j] = fishes[j+1]
    fishes[8] = 0
    
    fishes[6] += pregnantFishes
    fishes[8] += pregnantFishes

sum = 0
for fish in fishes:
    sum += fish

print(sum)

# part 2

fishes = [0]*9

for fish in lines:
    fishes[int(fish)] += 1

for i in range(256):
    pregnantFishes = fishes[0]

    for j in range(8):
        fishes[j] = fishes[j+1]
    fishes[8] = 0
    
    fishes[6] += pregnantFishes
    fishes[8] += pregnantFishes

sum = 0
for fish in fishes:
    sum += fish

print(sum)