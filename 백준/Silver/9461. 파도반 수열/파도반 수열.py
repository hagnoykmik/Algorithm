t = int(input())
for _ in range(t):
    n = int(input())
    p = [0] * 100

    p[0] = 1
    p[1] = 1
    p[2] = 1

    for i in range(3, n):
        p[i] = p[i-3] + p[i-2]

    print(p[n-1])