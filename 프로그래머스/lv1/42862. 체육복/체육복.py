def solution(n, lost, reserve):
    n_list = [num for num in range(1, n + 1) if num not in lost]
    
    # 만약에 여벌옷을 가져온 학생이 도난 당했을 때는 못 빌려준다.
    for i in range(1, n + 1):
        if i in lost and i in reserve:
            n_list.append(i)
            lost.remove(i)
            reserve.remove(i)
            
    # 정렬을 해줘야 남는 옷이 안생김
    lost.sort()
    reserve.sort()
    
    for i in lost:
        if i - 1 in reserve:
            n_list.append(i)
            reserve.remove(i - 1)
        elif i + 1 in reserve:
            n_list.append(i)
            reserve.remove(i + 1)
        elif not reserve: # 다 비었으면 중단
            break
    
    return len(n_list)