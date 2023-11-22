import sys
input = sys.stdin.readline

n = int(input())
command_list = [input().strip() for _ in range(n)]
stack = []

# 명령어
for command in command_list:

    if command == '2':
        if stack:
            print(stack.pop())
        else:
            print(-1)

    elif command == '3':
        print(len(stack))

    elif command == '4':
        if stack:
            print(0)
        else: 
            print(1)

    elif command == '5':
        if stack:
            print(stack[-1])
        else:
            print(-1)

    else:
        stack.append(int(command[2:]))