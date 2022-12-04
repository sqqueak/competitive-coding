# Advent of Code 2021 - Day 3: Binary Diagnostic
# 3 December 2021
# 
# 81 minutes

def binaryToDecimal(bin):
    binList = []
    binList[:0] = bin

    total = 0
    counter = 0

    for index in range(binList.__len__()-1, -1, -1):
        if(int(binList[index]) == 1):
            total += 2**counter
        counter += 1
    
    return total

def findMostCommonBit(list, index):
    counter0 = counter1 = 0

    for x in range(list.__len__()): # assuming that list is a 2D array; list of char lists
        if(list[x][index] == '0'):
            counter0 += 1
        else:
            counter1 += 1

    #print("METHOD", counter0, counter1)

    
    if(counter0 > counter1):
        return '0'
    else:
        return '1'

def findLeastCommonBit(list, index):
    counter0 = counter1 = 0

    for x in range(list.__len__()): # assuming that list is a 2D array; list of char lists
        if(list[x][index] == '0'):
            counter0 += 1
        else:
            counter1 += 1
    
    if(counter0 > counter1):
        return '1'
    else:
        return '0'

# reading input
f = open('inputs/day3.txt', 'r')
lines = f.readlines()

# part 1
binArray = []

for line in lines:
    binArray.append([*line.rstrip()])

gamma = ""
epsilon = ""

for x in range(binArray[0].__len__()):
    gamma += str(findMostCommonBit(binArray, x))
    epsilon += str(findLeastCommonBit(binArray, x))

print(int(binaryToDecimal(gamma) * int(binaryToDecimal(epsilon))))

# part 2

oxygen = binArray.copy()
co2 = binArray.copy()

for x in range(len(binArray[0])):
    mostCommon = findMostCommonBit(oxygen, x)

    oxygenCopy = oxygen.copy()

    for list in oxygenCopy:
        if(list[x] != mostCommon):
            oxygen.remove(list)

        if(len(oxygen) == 1):
            break

    if(len(oxygen) == 1):
            break

for x in range(len(binArray[0])):
    leastCommon = findLeastCommonBit(co2, x)

    co2Copy = co2.copy()

    for list in co2Copy:
        if(list[x] != leastCommon):
            co2.remove(list)

        if(len(co2) == 1):
            break

    if(len(co2) == 1):
            break

print(int(binaryToDecimal(oxygen[0])) * int(binaryToDecimal(co2[0])))