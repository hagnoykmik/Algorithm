import sys
input = sys.stdin.readline

n, s, r = map(int, input().split())
s_list = list(map(int, input().split()))
r_list = list(map(int, input().split()))
k_list = []

s_list.sort()
r_list.sort(reverse=-1)

# 자기 자신에게 여분의 카약을 쓸 때
for team in r_list:
    if team in s_list:
        s_list.remove(team)
    else:
        k_list.append(team)

# 남은 여분 카약으로 빌려주기
for team in k_list:
    if s_list == []:
        break
    elif team + 1 in s_list:
        s_list.remove(team + 1)
    elif team - 1 in s_list:
        s_list.remove(team - 1)
    
print(len(s_list))