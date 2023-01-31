n = int(input())
bracket = []

for _ in range(n):
    test = []
    bracket = list(input())
    for i in range(len(bracket)):
        if bracket[i] == '(':
            test.append(bracket[i])
        else:
            if len(test) != 0 and test[-1] == '(':
                test.pop()
            else:
                test.append(bracket[i])
    if len(test) != 0:
        print('NO')
    else:
        print('YES')