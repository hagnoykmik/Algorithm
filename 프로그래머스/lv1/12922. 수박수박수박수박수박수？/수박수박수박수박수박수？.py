def solution(n):
    answer = ''
    pattern = ['수', '박']
    
    for i in range(n):
        answer += pattern[i % 2]
    
    return answer