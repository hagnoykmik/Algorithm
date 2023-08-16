def solution(answers):
    answer = [0, 0, 0]          # 수포자가 맞춘 개수
    s1 = [1, 2, 3, 4, 5]
    s2 = [2, 1, 2, 3, 2, 4, 2, 5]
    s3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    result = []
    
    # answers가 수포자들의 방법보다 더 길 수 있으므로 나머지를 이용한다.
    for i, a in enumerate(answers):
        if s1[i % len(s1)] == a:
            answer[0] += 1
        if s2[i % len(s2)] == a:
            answer[1] += 1
        if s3[i % len(s3)] == a:
            answer[2] += 1
    
    # 가장 큰 수와 값이 같으면 리스트에 추가
    for n, score in enumerate(answer):
        if max(answer) == score:
            result.append(n + 1)
    
    return result