import sys
input = sys.stdin.readline

string = input().strip()
boom = input().strip()
n = len(string)
m = len(boom)
stack = []

for i in range(n):
    stack.append(string[i])

    if ''.join(stack[-m:]) == boom:
        for _ in range(m):
            stack.pop()
            
if stack:
    print(''.join(stack))
else:
    print('FRULA')

