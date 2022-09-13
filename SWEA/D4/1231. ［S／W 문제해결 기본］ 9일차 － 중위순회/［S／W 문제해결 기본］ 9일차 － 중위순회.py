for tc in range(1, 11):
    print('\n', f'#{tc}', end=' ')
    def inorder(n):
        if n:
            inorder(ch1[n])
            print(char[n], end='')
            inorder(ch2[n])


    V = int(input())
    E = V - 1
    char = [''] * (V + 1)
    ch1 = [0] * (V + 1)
    ch2 = [0] * (V + 1)
    root = 1

    for _ in range(V):
        nods = list(input().split())

        p = int(nods[0])
        char[p] = nods[1]

        if len(nods) > 2:
            for i in range(2, len(nods)):
                if ch1[p] == 0:
                    ch1[p] = int(nods[i])
                else:
                    ch2[p] = int(nods[i])
                    
    inorder(root)