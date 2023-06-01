input()
# can't use {int(x) for x in input().split(" ")} because cses wont accept it
print(len(set(input().split(" "))))
