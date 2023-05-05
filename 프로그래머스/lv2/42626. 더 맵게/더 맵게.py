import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)    # 기존 리스트를 힙으로 만들어준다
    
    while scoville[0] < K and len(scoville) >= 2:   
    # 맨 앞의 숫자가 K보다 크면 그 리스트의 모든 수는 K보다 크다 

        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)

        heapq.heappush(scoville, a + b * 2) # heap은 정렬안해도 됨

        answer += 1   

    # print(scoville[0])
    if scoville[0] < K:
        
        answer = -1

    return answer
