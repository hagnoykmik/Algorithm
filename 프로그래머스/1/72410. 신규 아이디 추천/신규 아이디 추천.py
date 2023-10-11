def solution(new_id):
    answer = ''
    impossible = '~!@#$%^&*()=+[{]}:?,<>/'
    
    # 1단계. 모든 대문자를 소문자로 치환한다.
    new_id = new_id.lower()
    
    # 2단계. 가능한 문자빼고 제거
    for char in new_id:
        if char not in impossible:
            answer += char
    
    # 3단계. 마침표 2개이상이면 하나로 치환한다.
    while '..' in answer:
        answer = answer.replace('..', '.',)
    
    # 4단계. 처음과 끝의 마침표 없애기
    answer = answer.strip('.')
    
    # 5단계. 빈문자열이면 a대입
    if answer == '':
        answer += 'a'
    
    # 6단계. 15글자로 맞춘다.
    answer = answer[:15].rstrip('.')
    
    # 7단계. 2글자보다 작을때 마지막 문자열 붙여준다.
    n = len(answer)
    if n <= 2:
        answer += answer[-1] * (3 - n)
        
    return answer