a, b = map(int, input().split())
n = a * b

if a < b:
    tmp = a
    a = b
    b = tmp

# 최대공약수
while b != 0:
    r = a % b
    a = b
    b = r
print(n // a)