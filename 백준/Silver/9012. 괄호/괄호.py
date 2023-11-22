import sys
input = sys.stdin.readline

t = int(input())
ps_list = [input().strip() for _ in range(t)]

for ps in ps_list:
    stack = []
    for vps in ps:
        # ( 일 때
        if vps == '(':
            stack.append(vps)
        
        # ) 일 때
        else:
            if stack:
                stack.pop()
            else:
                print('NO')
                break
    else:
        if stack:
            print('NO')
        else:
            print('YES')

