tae_bo = input()

left = 0
right = 0

for char in tae_bo:
    if char == '@':
        left += 1
    elif char == '(':
        break

for char in tae_bo[::-1]:
    if char == '@':
        right += 1
    elif char == ')':
        break

print(left, right)