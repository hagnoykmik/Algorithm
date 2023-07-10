from itertools import combinations  # 부분집합 메서드 사용

def solution(number):
    answer = 0
    
    for students in list(combinations(number, 3)): #combinations 메서드를 사용하면 객체 형태이기 때문에 리스트에 형변환해서 담아줘야 한다
        if sum(students) == 0:
            answer += 1
    
    return answer