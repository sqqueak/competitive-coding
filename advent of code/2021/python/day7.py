# Advent of Code 2021 - Day 7: The Treachery of Whales
# 7 December 2021
# 
# 20 minutes

def limitToMiddleThird(input):
    sum = 0
    for line in input:
        sum += int(line) # assuming input is a string of numbers
    
    average = sum / len(input)

    lowerBound = round(average * 0.33)
    upperBound = round(average) + round(average * 0.165)

    return [lowerBound, upperBound]

# reading input
f = open('inputs/day7.txt', 'r')
lines = f.readlines()

lines = lines.pop().rstrip().split(",")

# part 1
finSum = float('inf')
totalSum = 0

bounds = limitToMiddleThird(lines)

for i in range(int(bounds[0]), int(bounds[1])):
    for line in lines:
        totalSum += abs(i-int(line))
    
    if(totalSum < finSum):
        finSum = totalSum
    
    totalSum = 0

print(finSum)

# part 2
finSum = float('inf')
totalSum = 0

for i in range(int(bounds[0]), int(bounds[1])):
    for line in lines:

        for step in range(1, abs(i-int(line))+1 ): # slow for some reason
            totalSum += step
    
    if(totalSum < finSum):
        finSum = totalSum
    
    totalSum = 0

print(finSum)