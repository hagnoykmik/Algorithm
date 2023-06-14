t = int(input())
for tc in range(t):
    n = int(input())
    card = list(map(int, input()))
    card_list = [0] * (max(card) + 1)
    max_num = 0

    for i in card:
        card_list[i] += 1

    for i, num in enumerate(card_list):
        if num >= max_num:
            max_num = num
            index_num = i
            
    print(f'#{tc + 1} {index_num} {max_num}')