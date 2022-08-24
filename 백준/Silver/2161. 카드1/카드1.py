n = int(input())
queue = []

# 먼저 n장의 카드를 큐에 담는다
for i in range(1, n+1):
    queue.append(i)


while queue:
    q = queue.pop(0)     # 제일 위에(앞) 있는 카드를 버린다
    print(q, end=' ')

    if queue:            # 비어있지 않으면
        q = queue.pop(0)     # 다음장의 카드를 뽑아서
        queue.append(q)      # 맨 뒤에 넣는다