def solution(t, p):
    num_list = []
    
    for i in range(0, len(t)-len(p)+1):
        if t[i:i+len(p)] <= p:
            num_list.append(t[i:i+len(p)])
        
    return len(num_list)
