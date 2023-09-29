import sys
input = sys.stdin.readline

n = int(input())
stack = []

for _ in range(n):
    command = input().strip() # string받을 때는 개행문자가 같이 오기때문에 제거 해줘야함

    if command == 'pop':
        if stack:
            print(stack.pop())
        else:
            print(-1)

    elif command == 'size':
        print(len(stack))

    elif command == 'empty':
        if not stack:
            print(1)
        else:
            print(0)

    elif command == 'top':
        if stack:
            print(stack[-1])
        else:
            print(-1)

    else:
        command, x = map(str, command.split())
        stack.append(int(x))