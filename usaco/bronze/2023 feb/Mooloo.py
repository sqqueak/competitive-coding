# dnf

N, K = list(map(int, input().split(" ")))
days = list(map(int, input().split(" ")))
COST = 0

differences = [j-i for i,j in zip(days, days[1:])]
stable = [K+1 for _ in range(len(differences))]
stable[0] += K+1

print(differences)
print(stable)
current = 0
counter = 1

for i in range(len(differences)):
    print(differences[i])
    print(stable[i])