def solution(k, tangerine):
    tangerine_set = set(tangerine)
    t_count = {i:0 for i in list(tangerine_set)}
    answer = 0
    size = 0
    
    # 몇개인지 세서 딕셔너리에 번호:개수 넣기
    for t in tangerine:
        t_count[t] += 1
    
    # 리스트에 담아서 개수많은 순으로 정렬
    new_tangerine = list(t_count.items())
    new_tangerine.sort(key=lambda x: -x[1])

    for num, cnt in new_tangerine:
        if k > 0:
            k -= cnt
            size += 1
        else:
            break
        
    return size