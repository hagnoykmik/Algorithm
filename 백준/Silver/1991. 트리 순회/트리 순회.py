# 전위 순회
def preorder(v):
    if v:
        print(parent[v], end='')
        preorder(parent.index(child_1[v]))
        preorder(parent.index(child_2[v]))

# 중위 순회
def inorder(v):
    if v:
        inorder(parent.index(child_1[v]))
        print(parent[v], end='')
        inorder(parent.index(child_2[v]))

# 후위 순회
def postorder(v):
    if v:
        postorder(parent.index(child_1[v]))
        postorder(parent.index(child_2[v]))
        print(parent[v], end='')


n = int(input())
parent = ['.']
child_1 = ['.']
child_2 = ['.']

for _ in range(n):
    p, ch1, ch2 = input().split()
    parent.append(p)
    child_1.append(ch1)
    child_2.append(ch2)


preorder(1)
print()
inorder(1)
print()
postorder(1)
