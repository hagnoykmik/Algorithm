def solution(food):
    answer = ''
    for n, f in enumerate(food):
        # n번째 음식을 f//2번 먹어야한다
        for _ in range(int(f)//2):
            answer += str(n)
    answer += '0' # 물
    # 물을 제외한 음식 거꾸로 붙이기
    for i in range(len(answer)-2, -1, -1):
        answer += answer[i]
    
    return answer