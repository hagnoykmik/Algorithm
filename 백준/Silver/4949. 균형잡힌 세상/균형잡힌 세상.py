import sys
input = sys.stdin.readline

while 1:
    string = input().rstrip()
    stack = []
    
    # 종료조건
    if string == '.':
        break

    for char in string:
        if char == '(' or char == '[':
            stack.append(char)
        elif char == ')': 
            if stack and stack[-1] == '(': 
                stack.pop()
            else:
                print('no')
                break
        elif char == ']':
            if stack and stack[-1] == '[':
                stack.pop()
            else:
                print('no')
                break

    else:
        if not stack:
            print('yes')
        else:
            print('no')
