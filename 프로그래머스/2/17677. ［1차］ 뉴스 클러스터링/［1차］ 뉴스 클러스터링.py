import math

def solution(str1, str2):
    answer = 0
    str1 = str1.lower()
    str2 = str2.lower()
    
    # 두 글자씩 끊어서 다중집합의 원소로 만든다.
    new_str1 = [] 
    new_str2 = []
    
    # 첫번째 문자열은 다 넣기
    for j in range(len(str1) - 1):
        new_word = (str1[j] + str1[j + 1])
        if new_word.isalpha():
            new_str1.append(new_word)

    for i in range(len(str2) - 1):
        new_word = (str2[i] + str2[i + 1])
        if new_word.isalpha():
            new_str2.append(new_word)
    
    # 교집합, 합집합 구하기
    intersection = []
    
    for element in new_str2:
        # new_str2에는 있고 new_str1에 없는 거
        if element in new_str1:
            # 둘다 있는거 제거 -> 차집합(new_str1 - (new_str2 교 new_str1))
            new_str1.remove(element)
            intersection.append(element)
    
    n = len(intersection)
    m = len(new_str1 + new_str2)

    if n == 0 and m == 0:
        answer = 65536
    else:
        answer = math.floor((n / m) * 65536) 
    
    
    return answer