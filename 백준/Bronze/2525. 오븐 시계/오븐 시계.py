h, m = map(int, input().split())
c = int(input())

# 걸리는 시간 계산
m += c
if m >= 60:
    h += (m // 60)
    m %= 60

# 24시간을 지났을 때
if h >= 24:
    h -= 24
    
print(h, m)   
