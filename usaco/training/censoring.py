# 2015 feb bronze
# 05/2023

import sys

f = open("censor.in")
S = f.readline().strip()
T = f.readline().strip()

# next 2 solutions are too slow

# pre = len(T) * "x"
# buf = 0
# for i in range(len(S)-len(T)+1):
#     if(S[i:i+len(T)] == T):
#         buf += len(T)
#         S = pre + S[:i] + S[i+len(T):]

# censored = ""
# for c in S:
#     censored += c
#     if(T in censored):
#         censored = censored[:len(censored)-len(T)]

# official solution from usaco.guide is fast enough?
censored = ""
for char in S:
	censored += char
	if censored[-len(T) :] == T:
		censored = censored[: -len(T)]
		
# i think it's because `T in censored` takes longer since its searching the entire censored string?
# as opposed to just checking if the end of the string is T

with open("censor.out", "w") as f:
    sys.stdout = f
    print(censored)
