from collections import deque
def solution(dartResult):
    score = ""
    stack = []
    
    for n in dartResult:
        if n.isdigit():
            score = score + n  
        elif n == "S":
            stack.append(int(score) ** 1)
            score = ""
        elif n == "D":
            stack.append(int(score) ** 2)
            score = ""
        elif n == "T":
            stack.append(int(score) ** 3)
            score = ""
        elif n == "#":
            score = stack.pop()
            stack.append(score * (-1))
            score = ""
        else:
            num1 = stack.pop()
            if stack:
                num2 = stack.pop()
                stack.append(num2 * 2)
            stack.append(num1 * 2)
            
    return sum(stack)