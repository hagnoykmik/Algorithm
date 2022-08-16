t = int(input())

for tc in range(1, t+1):
    A, B = input().split()
    # banana, bana

# b에 저장된 문자열을 한글자로 바꿔준다
    if B in A:
       A = A.replace(B, '.')
       cnt = len(A)

    print(f'#{tc} {cnt}')