def solution(ingredient):
    answer = 0
    hamburger = [1,2,3,1]
    # 빵-야채-고기-빵
    # 1231
    i = 0
    while i < len(ingredient):
        if ingredient[i:i+4] == hamburger: # ingredent[i]가 1인지 확인하는 부분은 불필요
            answer += 1
            del ingredient[i:i+4]
            if i < 4:
                i = 0
            else:
                i -= 4
        else:
            i += 1
    
    return answer