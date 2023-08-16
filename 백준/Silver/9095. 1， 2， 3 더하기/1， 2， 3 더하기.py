# 경우의 수 만들기
numbers = [0, 1, 2, 4]
for n in range(4, 13):
    numbers.append(numbers[n-1] + numbers[n-2] + numbers[n-3])

for t in range(int(input())):
    n = int(input())
    print(numbers[n])
