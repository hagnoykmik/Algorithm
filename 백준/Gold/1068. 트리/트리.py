n = int(input())
tree_list = map(int, input().split())
del_node = int(input())
delete_nodes = [del_node] # 스택
tree = [[] for _ in range(n)]
leaf = 0

# 트리 자식관계 매핑
for i, num in enumerate(tree_list):
    if num != -1:
        tree[num].append(i)

# 삭제노드에 연결된 노드 삭제 (dfs)
while delete_nodes: # 빌때까지
    delete_node = delete_nodes.pop() # 삭제할 노드 번호 뽑기
    for node in tree[delete_node]:
        delete_nodes.append(node)
    tree[delete_node] = "X"

# 삭제노드 부모 리스트에서 삭제
for node_list in tree:
    if node_list == "X":
        pass
    else:
        if del_node in node_list:
            node_list.remove(del_node)
            break # 찾았으면 탈출 

# 리프노드 찾기
for child in tree:
    if child == []:
        leaf += 1
        
print(leaf)