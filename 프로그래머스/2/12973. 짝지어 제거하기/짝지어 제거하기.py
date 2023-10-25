def solution(s):
    string = []
    
    for c in s:
        if string and string[-1] == c:
            string.pop()
        else:
            string.append(c)
            
    if not string:
        return 1
    else:
        return 0
