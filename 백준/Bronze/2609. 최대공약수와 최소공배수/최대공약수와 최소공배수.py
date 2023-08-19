a, b = map(int, input().split())

# 최대 공약수
def gcd(a, b):
    # a에 더 큰수를 담는다.
    if a < b:
        tmp = a
        a = b
        b = tmp
    # 유클리드 알고리즘
    while b != 0:
        r = a % b
        a = b
        b = r
    return a
gcd = gcd(a, b)
print(gcd)

# 최소 공배수
def lcm(a, b, gcd):
    return (a * b) // gcd 

print(lcm(a, b, gcd))