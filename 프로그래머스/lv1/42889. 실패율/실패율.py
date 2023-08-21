def solution(N, stages):
    stages.sort()      # 1번부터 정렬
    failure_list = []  # 실패율 리스트
    user = len(stages) # 사용자 수
    
    for stage in range(1, N+1):
        # 해당 스테이지에 도달한 플레이어 수
        players_on_stage = stages.count(stage)
        
        if user == 0:
            failure_list.append((stage, 0))
        else:
            failure_list.append((stage, players_on_stage / user)) # 실패율을 구해서 리스트에 넣고))
            user -= players_on_stage  # 스테이지 제거
            
            
    # 내림차순으로 정렬
    failure_list.sort(reverse=True, key=lambda x: x[1])
    answer = [stage for stage, _ in failure_list]
        
    return answer