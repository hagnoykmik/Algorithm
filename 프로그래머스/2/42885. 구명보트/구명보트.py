# 제일 무거운애랑 제일 가벼운애랑 태운다
# 투포인터가 제일 효율적인 방법
def solution(people, limit):
    answer = 0
    n = len(people)
    people.sort(reverse=-1)
    start, end = 0, n - 1
    
    while start <= end:
        if people[start] + people[end] <= limit:
            start += 1
            end -= 1
        else:
            start += 1
        answer += 1
        
    return answer