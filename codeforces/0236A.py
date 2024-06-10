#  2022 sep 10

n = str(input())
d = {}
for ch in n:
    if ch in d:
        d[ch] += 1
    else:
        d[ch] = 1

print("CHAT WITH HER!") if len(d) % 2 == 0 else print("IGNORE HIM!")
