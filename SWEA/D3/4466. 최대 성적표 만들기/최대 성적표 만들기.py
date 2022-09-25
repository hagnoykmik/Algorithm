t = int(input())
for tc in range(1, t + 1):
    n, k = map(int, input().split())
    arr = list(map(int, input().split()))

    # 내림차순으로 정렬
    arr = sorted(arr, reverse=-1)
    
    print(f'#{tc} {sum(arr[:k])}')