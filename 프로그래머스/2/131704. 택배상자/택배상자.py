from collections import deque
def solution(order):
    answer = 0
    box = 1
    stack = []
    
    while box != len(order) + 1:
        # 보조 컨테이너에 넣기
        stack.append(box)
        
        # 보조 컨테이너에 있는게 지금 실어야될 상자인지 체크
        while stack[-1] == order[answer]:
            answer += 1
            stack.pop()
            
            if not stack:
                break
        
        box += 1
    
    return answer