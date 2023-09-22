'''
1. 아이디어
- for문돌면서 k개를 더해준다
- 이중 for문 돌리려고 했더니 시간 복잡도가 너무 높다 (for문 * for문 = 100,000 * 100,000 == 10억? => 5초)
- 리스트 슬라이싱을 이용하면? (my_list[a:b] 를 하면 시간 복잡도 는 O(b-a)) -> 이중 for문이랑 비슷하지 않나?
=> 그럼어떻게 해야돼?
슬라이딩윈도우

2. 시간복잡도
- for문 = 99,999

3. 자료구조
- 누적합을 더하는 리스트 : int[]
'''

import sys
input = sys.stdin.readline

n, k = map(int, input().split())
t_list = list(map(int, input().split()))
sum_list = []
previous_sum = sum(t_list[:k])
sum_list.append(previous_sum)

for i in range(n-k):
    previous_sum -= t_list[i]   # 맨앞에 빼주고
    previous_sum += t_list[i+k] # 뒤에거 더해준다
    sum_list.append(previous_sum)

print(max(sum_list))