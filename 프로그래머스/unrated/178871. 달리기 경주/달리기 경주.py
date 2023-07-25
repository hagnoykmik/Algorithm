def solution(players, callings):
    
    # 리스트 index메서드는 시간이 오래걸려서, 딕셔너리 형태로 인덱스와 플레이어를 매핑
    player_d = {player:i for i, player in enumerate(players)}
    
    # 추월한 선수로 인덱스를 찾는다
    for c in callings:
        i = player_d[c]
        # 리스트 순서 바꾸기
        players[i], players[i-1] = players[i-1], players[i]
        # 바뀐 값 딕셔너리에 업데이트 해주기
        player_d[players[i]], player_d[players[i-1]] = player_d[players[i-1]], player_d[players[i]] 
    return players