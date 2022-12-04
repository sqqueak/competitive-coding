cases = input()

for i in range(int(cases)):
    n = int(input())
    st = list(input().split())
    res = "Case #" + str(i+1) + ":"

    for s in range(n): # student picking a mentor
        c = st.copy()
        c.remove(st[s])
        # possible mentors then taking max
        m = min( [int(r) for r in c] )
        if int(st[s])*2 < int(m):
            res += " -1"
        else:
            res += " " + str(max( [int(r) for r in c if int(r) <= (int(st[s])*2)] ))
    
    print(res)