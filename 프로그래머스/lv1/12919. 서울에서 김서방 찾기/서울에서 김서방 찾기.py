def solution(seoul):
    answer = ''
    
    for idx, name in enumerate(seoul):
        if name == "Kim":            
            answer = f"김서방은 {idx}에 있다"
        
    return answer