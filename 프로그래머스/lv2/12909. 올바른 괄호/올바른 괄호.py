def solution(s):
    answer = True
    stack = []
    
    # () 올바른 괄호
    for bracket in s:
        stack.append(bracket)
        if len(stack) > 1 and bracket == ')' and stack[-2] == '(':
            stack.pop()  # ')'
            stack.pop()  # '('
    if stack:
        answer =  False
    
    return answer