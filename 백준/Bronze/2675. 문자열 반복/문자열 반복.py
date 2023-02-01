for _ in range(int(input())):
    p = ''
    n, s = input().split()
    for i in range(len(s)):
        p += s[i] * int(n)
    print(p)