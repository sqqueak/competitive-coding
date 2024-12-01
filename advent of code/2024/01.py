# 00:02:41   607  //  00:03:55   415

from collections import Counter

def parse_input(inp_content):
  l1, l2 = [], []
  for line in inp_content.strip().split("\n"):
    x, y = list(map(int, (line.split("  "))))
    l1 += [x]
    l2 += [y]
  return l1, l2


def solve_l1(input_str):
  l1, l2 = parse_input(input_str)
  l1.sort()
  l2.sort()
  return sum([abs(x - y) for x, y in zip(l1, l2)])


def solve_l2(input_str):
  l1, l2 = parse_input(input_str)
  c = Counter(l2)
  return sum([x * c[x] for x in l1])
