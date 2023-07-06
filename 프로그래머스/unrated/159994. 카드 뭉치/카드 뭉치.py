def solution(cards1, cards2, goal):
    answer = 'Yes'
    
    for word in goal:
        # cards1에 있고 맨앞에있는지 체크
        if (word in cards1) and (cards1.index(word) == 0):
            cards1.remove(word)
        
        # cards2에 있고 맨앞에있는지 체크
        elif (word in cards2) and (cards2.index(word) == 0):
            cards2.remove(word)
            
        else:
            answer = 'No'
            break
    
    return answer