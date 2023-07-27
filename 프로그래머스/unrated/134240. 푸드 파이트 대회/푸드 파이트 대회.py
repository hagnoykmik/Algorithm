def solution(food):
    first = ''
    for n, f in enumerate(food):
        # n번째 음식을 f//2번 먹어야한다
        first += str(n) * (int(f)//2)
        
    # 물을 제외한 음식 거꾸로 붙이기
    second = first[::-1]
    answer = first + '0' + second
    return answer