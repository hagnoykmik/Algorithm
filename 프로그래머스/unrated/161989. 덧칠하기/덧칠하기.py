def solution(n, m, section):
    cnt = 0
    painted = set()
    
    for i in section:
        if i not in painted: # 다른거 칠할 때 칠해진거 아니면
            cnt += 1
            for j in range(i, i + m):
                if j < n + 1: # 칠해야 하는 범위 내에 있으면 칠해준다(set에 추가)
                    painted.add(j)
    return cnt