'''
1. 아이디어
- X로 되어 있는 칸 중에 3개인 조합을 다 탐색해서 다 막을 수 있는 위치를 찾는다.

2. 시간복잡도

3. 자료구조

'''
import sys
input = sys.stdin.readline


# 조합
def combinations(arr, start):
    # 종료조건
    if len(arr) == 3:
        # 장애물 설치하러 가기
        answer = search(arr)
        # 감시를 다 피할 수 있는 장애물 위치를 찾으면 중단
        if answer == 'YES':
            return answer
        return 

    # 조합 진행
    for i in range(start, len(location_list)):
        arr.append(location_list[i])
        # 재귀를 돌았는데 YES가 나오면 중단하고 answer를 반환
        if combinations(arr, i + 1) == 'YES':
            return 'YES'
        arr.pop()
    # 다 정상적으로 돌았으면 NO반환
    return 'NO'


# 장애물 놓기
def search(arr):
    answer = 'NO'
    # print(arr)
    student_cnt = 0 # 걸린 학생 수
    # 선생님 한명씩 감시
    for teacher in teachers:
        r, c = teacher
        
        # 선생님이 감시할 수 있는 범위(상하좌우로 한줄씩)
        dr = [-1, 1, 0, 0] 
        dc = [0, 0, -1, 1]

        for i in range(4):
            
            for j in range(1, n+1):
                nr = r + (dr[i] * j)
                nc = c + (dc[i] * j) 
                
                # 감시 범위 내에 있고
                if 0 <= nr < n and 0 <= nc < n:
                    # 장애물이 있으면
                    if (nr, nc) in arr:
                        break # 그방향 탐색 중단
                    elif corridor[nr][nc] == 'S':
                        student_cnt += 1
                        break
        if student_cnt > 0:
            break
    
    if student_cnt == 0:
        answer = 'YES'

    return answer


n = int(input())
corridor = [list(input().split()) for _ in range(n)]
location_list = [] # 빈칸 좌표 리스트
teachers = []      # 선생님 좌표 리스트

# 빈칸 찾기
for x in range(n):
    for y in range(n):
        if corridor[x][y] == 'X': # 빈칸이면 좌표 저장
            location_list.append((x, y))
        elif corridor[x][y] == 'T': # 선생님 위치도 저장
            teachers.append((x, y))

# 조합 뽑기
print(combinations([], 0))