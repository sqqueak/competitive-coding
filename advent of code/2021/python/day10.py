# Advent of Code 2021 - Day 10: 
# 25 January 2022
# 
# 9:37a
# learning how to use queue modules, specifically LIFO queue

from queue import LifoQueue

def isOpener(ch):
    if(ch == '[' or ch == '<' or ch == '(' or ch == '{'):
        return True
    return False

def isOpposite(ch, q): # ch is probably closer, q is q.pop
    
        
# reading input
f = open('inputs/day10.txt', 'r')
lines = f.readlines()

for line in lines: # iterating through each broken line
    line = list(line.rstrip())

    q = LifoQueue()

    for i in line:
        if(isOpener(i)):
            q.put(i)
        else: # character is a "closer"
            print(i)
    

    print('\n')