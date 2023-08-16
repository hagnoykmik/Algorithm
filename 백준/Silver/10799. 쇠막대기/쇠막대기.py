bars = input()
stack = []
answer = 0

# 자르기
for i in range(len(bars)):
    # (일때
    if bars[i] == '(':
        stack.append('(')
    # )는 레이저이거나 막대기가 끝남
    else:
        # ()(레이저) -> 자르고 나서 남은 열린괄호(막대기)수 더해주기
        if bars[i-1] == '(':
            stack.pop()
            answer += len(stack)
        # )) -> 막대기가 하나 끝난 것
        else:
            stack.pop() # 하나의 (를 빼준다(막대기 제거)
            answer += 1 # 막대기 토막 하나 더해주기
            
print(answer)
