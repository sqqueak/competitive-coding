def is_palindrome(s):
    for r,t in zip(s, reversed(s)):
        if r != t:
            return False
    return True

pal = input()
print(list(pal) / 2)