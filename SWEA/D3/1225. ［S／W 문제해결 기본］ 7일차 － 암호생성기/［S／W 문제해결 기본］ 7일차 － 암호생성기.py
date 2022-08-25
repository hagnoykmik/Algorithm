for tc in range(1, 11):
    t = int(input())
    queue = list(map(int, input().split()))

    while queue[-1] != 0:           # 큐의 마지막값이 0이 되면 멈춘다
        for i in range(1, 6):       # 5번의 사이클 
            p = queue.pop(0)
                                    # p-i가 0보다 클 때
            if p > i:               
                queue.append(p - i)

            else:                   # p-i가 0보다 작을 때
                queue.append(0)
                break               

    print(f'#{tc}', *queue)