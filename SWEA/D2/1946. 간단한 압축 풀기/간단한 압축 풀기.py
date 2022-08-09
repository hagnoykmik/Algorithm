T = int(input())

for tc in range(1, T+1):
    N = int(input())
    text = ''
    for n in range(N):
        alpa, num = input().split()
        text += alpa*int(num)
    print('#{}'.format(tc))
    for i in range(1,len(text)+1,10):
        print(text[i-1:i+10-1])