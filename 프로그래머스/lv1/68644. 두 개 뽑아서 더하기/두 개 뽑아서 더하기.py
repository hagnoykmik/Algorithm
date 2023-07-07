def solution(numbers):
    answer = set()
    
    for i in range(len(numbers)):
        for j in range(i+1, len(numbers)):
            answer.add(numbers[i] + numbers[j])        
        
    return sorted(list(answer))  # TypeError: Object of type set is not JSON serializable가 나면 list로 감싸줘야 제대로 인식
