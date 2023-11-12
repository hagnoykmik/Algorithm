from collections import deque
def solution(priorities, location):
    priorities_sort = sorted(priorities, reverse=-1) # 우선순위 높은 것부터 정렬
    priorities_q = deque((i, p) for i, p in enumerate(priorities))
    run = [] # 실행시킨 순서
    
    while priorities_q:
        idx, priority = priorities_q.popleft()
        
        # 자신보다 우선순위가 높은 프로세스가 있을 때
        if priority != priorities_sort[0]:
            priorities_q.append((idx, priority))
            
        # 자기가 제일 우선순위 높을 때
        else:
            run.append(priorities_sort.pop(0))
            if idx == location:
                return len(run)
        