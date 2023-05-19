# 2019 jan bronze
# 05/2023

import sys

f = open("shell.in")

N = int(f.readline())
shells = [0,1,2]
guess = [0] * 3

for i in range(N):
    a, b, g = list(map(int, f.readline().split(" ")))

    # swapping shell a and b
    temp = shells[a-1]
    shells[a-1] = shells[b-1]
    shells[b-1] = temp

    # counting correct guesses
    guess[shells[g-1]] += 1

with open("shell.out", "w") as f:
    sys.stdout = f
    print(max(guess))
