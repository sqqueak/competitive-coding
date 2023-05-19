for _ in range(int(input())):
    l = int(input())
    a = list(map(int, input().split(" ")))
    b = list(map(int, input().split(" ")))

    Ma = max(a)
    Mb = max(b)

    if(a[l-1] != Ma and b[l-1] != Mb):
        print("No")
    elif(a[l-1] == Ma and b[l-1] == Mb):
        print("Yes")
    else:

        if(a[l-1] == Ma):
            for i in range(l):
                pa = a[i]
                pb = b[i]

                if(pa <= Mb and pb < pa):
                    temp = pa
                    a[i] = pb
                    b[i] = temp

        elif(b[l-1] == Mb):
            for i in range(l):
                pa = a[i]
                pb = b[i]

                if(pb <= Ma and pa < pb):
                    temp = pa
                    a[i] = pb
                    b[i] = temp

        Ma = max(a)
        Mb = max(b)
        if(a[l-1] == Ma and b[l-1] == Mb):
            print("Yes")
        else:
            print("No")
