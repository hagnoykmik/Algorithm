def solution(s):
    answer = True
    stack = []
    for bracket in s:
        if bracket == '(':
            stack.append(bracket)
        else:
            if stack and stack[-1] == '(':
                stack.pop()
            else:
                answer = False
                break

    if not stack:
        return answer
    else:
        return not answer