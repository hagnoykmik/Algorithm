for tc in range(1, 11):
    t = int(input())
    word = input()

    stack = []
    result = ''

    # 후위표기법
    for token in word:
        # 연산자일 때
        if token in '*+()':
            if not stack or token == '(':
                stack.append(token)
            elif token == '*':
                while stack and stack[-1] == '*':
                    result += stack.pop()
                stack.append(token)
            elif token == '+':
                while stack and stack[-1] != '(':
                    result += stack.pop()
                stack.append(token)
            elif token == ')':
                while stack[-1] != '(':
                    result += stack.pop()
                stack.pop()
        # 피연산자일 때
        else:
            result += token

    # 스택이 안 비워져있을 때 다 담기
    while stack:
        result += stack.pop()


    # 연산
    for char in result:
        # 피연산자일 때
        if char not in '*+':
            stack.append(int(char))
        else:
            y = stack.pop()
            x = stack.pop()

            if char == '*':
                stack.append(x * y)
            elif char == '+':
                stack.append(x + y)

    print(f'#{tc} {stack[-1]}')
