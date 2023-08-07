import sys
dice = sys.stdin.readline().split()
num_dict = {num:dice.count(num) for num in dice} # 주사위 숫자:몇번 나왔는지

num_list = sorted(num_dict.items(), reverse=True, key=lambda x : (x[1], x[0])) # 개수가 많은 것 부터 나열, 개수가 같으면 숫자가 큰 수부터 나열
cnt = len(num_list) # 다 같은 눈이면 길이가 1, 두개가같으면 길이가 2, 다 다르면 3
c1, c2, c3 = 0, 0, 0

# 같은 눈이 3개
if cnt == 1:
    c1 = 1
    c2 = int(num_list[0][0])
# 같은 눈이 2개
elif cnt == 2:
    c2 = 1
    c3 = int(num_list[0][0])
# 다 다른 눈
else:
    c3 = int(num_list[0][0])
result = (10000 * c1) + (1000 * c2) + (100 * c3)

print(result)