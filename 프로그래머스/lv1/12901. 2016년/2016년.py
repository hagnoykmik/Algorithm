def solution(a, b):
    answer = ''
    # 1,1 -> FRI
    days = ['FRI','SAT','SUN','MON','TUE','WED','THU']
    month = [0,31,29,31,30,31,30,31,31,30,31,30,31]
    
    day = sum(month[:a]) + b # a달 전 달까지 일수 다 더하기 + b(일수) 더하기
    
    return days[day % 7 - 1] # 나머지는 인덱스 +1