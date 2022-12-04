import math

def decode(text):
    return "".join(chr(c) for c in text)

prime = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]
C = [156, 104, 128, 36, 158, 50]
M =  [65, 104, 111, 121, 97, 33]

posE = []
posD = []
E = 0
D = 0

for pr in prime:
    if(math.gcd(192,pr)==1):
        ch = True
        for i in range(6):
            if(C[i] != pow(M[i],pr)%221):
                ch=False

        if(ch):
            posE.append(pr)

for i in range(200):
    ch=True
    for j in range(6):
        if(M[j] != pow(C[j],i)%221):
            ch=False
            break
    
    if(ch):
        posD.append(i)

# make list of possibilities for e,d
# then run to see which combo decrypts to string w/ "Ahoya!"

for e in posE:
    for d in posD:
        if((d*e)%192==1):
            E=e 
            D=d 
            break
        
    if(e!=0):
        break



print(e, d)
        

