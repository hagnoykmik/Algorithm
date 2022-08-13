
t = 10
for tc in range(1, t+1):

    n = input()
    arr = [list(map(int, input().split())) for _ in range(100)]


    maxS = float('-inf')  

    for i in range(100):
        rs = 0 
        for j in range(100):
            rs += arr[i][j]

            if maxS < rs:
                maxS = rs

    for i in range(100):
        cs = 0  
        for j in range(100):
            cs += arr[j][i]

            if maxS < cs:
                maxS = cs

    s1 = 0  
    for i in range(100):
        s1 += arr[i][i]

        if maxS < s1:
            maxS = s1

    s2 = 0
    for i in range(100):
        s2 += arr[i][99 - i]

        if maxS < s2:
            maxS = s2

    print(f'#{tc} {maxS}')