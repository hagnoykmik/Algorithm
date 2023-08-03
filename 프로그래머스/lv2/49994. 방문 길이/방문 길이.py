def solution(dirs):
    answer = 0
    move = {'U':(0,1), 'D':(0,-1), 'R':(1,0), 'L':(-1,0)} # 이동방향
    dir_list = []
    sx, sy = 0, 0 # 출발점
    x, y = 0, 0   # 이동한 점
    for d in dirs:
        x = sx + move[d][0] # 이전 점 + 이동거리
        y = sy + move[d][1] 
        # 범위를 넘어가지 않아야만 이동리스트에 넣어준다
        if -5 <= x <= 5 and -5 <= y <= 5:
            move_list = sorted([(sx,sy),(x,y)])
            # 왼->오와 오->왼은 같은 길이라 중복검사를 해준다
            if move_list not in dir_list:
                dir_list.append(move_list)      # [(이전점),(이동점)] 
            sx, sy = x, y   # 이동한 점을 이전점으로 바꿔준다
        else:
            continue
    
    return len(dir_list)