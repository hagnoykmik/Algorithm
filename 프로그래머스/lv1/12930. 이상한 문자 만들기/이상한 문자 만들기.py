def solution(s):
    answer = ''
    
    list_s = s.split(' ')
    cnt = 0 # 마지막 단어에 공백 안붙이기 위해서 회수 카운트
    
    for word in list_s:
        for i in range(len(word)):
            if i % 2:
                answer += word[i].lower()
            else:
                answer += word[i].upper()
        cnt += 1
        
        if cnt != len(list_s):  # 마지막 단어 빼고 공백 붙이기
            answer += ' '
    
    return answer