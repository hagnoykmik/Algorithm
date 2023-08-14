def solution(numbers):
    answer = [-1] * len(numbers)
    i_stack = []
    
    for i, num in enumerate(numbers):
        # 스택이 비어있지 않고 맨위 인덱스의 값보다 현재 숫자가 더 크면 그 인덱스의 값을 지금 숫자로 바꿔준다.
        while i_stack and numbers[i_stack[-1]] < num:
            answer[i_stack.pop()] = num
        
        
        # 현재 인덱스를 넣는다
        i_stack.append(i)
    
    
    return answer