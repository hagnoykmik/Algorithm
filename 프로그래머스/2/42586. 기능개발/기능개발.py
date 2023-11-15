from collections import deque

def solution(progresses, speeds):
    answer = []
    progresses = deque(progresses)
    speeds = deque(speeds)
    
    while progresses:
        complete = 0
        # 작업
        for i in range(len(progresses)):
            progresses[i] += speeds[i]
            
        # 작업 완료된거 빼기 => 이때 작업속도도 같이 제거해줘야한다.
        while progresses and progresses[0] >= 100:
            progresses.popleft()
            speeds.popleft()
            complete += 1
        
        if complete != 0:
            answer.append(complete)
    
    return answer