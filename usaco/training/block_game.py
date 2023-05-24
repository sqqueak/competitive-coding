# 2016 dec bronze
# 05/2023

# O(NM), M is the length of the longest word

import sys

f = open("blocks.in")
N = int(f.readline())
occs = [0] * 26
alphabet = ['a','b','c','d','e',
            'f','g','h','i','j',
            'k','l','m','n','o',
            'p','q','r','s','t',
            'u','v','w','x','y',
            'z']

for i in range(N):
    a, b = list(f.readline().strip().split(" "))
    for i in range(26):
        # add max number of occurences of each letter per pair of words
        occs[i] += max(len([x for x in list(a) if x == alphabet[i]]), len([x for x in list(b) if x == alphabet[i]]))

with open("blocks.out", "w") as f:
    sys.stdout = f
    for i in occs:
        print(i)
    
