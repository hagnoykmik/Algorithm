for tc in range(1, 11):
    n, numbers = input().split()   #한개씩 쪼개기 위해 문자열로 받는다

    my_stack = []

    for i in numbers:

        if not my_stack:
            my_stack.append(i)

        else:
            if my_stack[-1] == i:
                my_stack.pop()
            else:
                my_stack.append(i)

    pw = ''                         # 비밀번호를 담을 문자열

    for j in range(len(my_stack)):
        pw += my_stack[j]

    print(f'#{tc} {pw}')
