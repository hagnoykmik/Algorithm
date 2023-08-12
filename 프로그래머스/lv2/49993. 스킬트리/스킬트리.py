def solution(skill, skill_trees):
    answer = 0
    
    # 가능한 스킬트리 조합들
    skill_tree_list = ['']
    skills = ''
    for s in skill:
        skills += s
        skill_tree_list.append(skills)
    
    # C,B,D 만 있는 문자열 새로 만들기
    for skill_tree in skill_trees:
        new_set = ''
        for char in skill_tree:
            if char in skill:
                new_set += char
        # 스킬트리 가능여부 체크
        if new_set in skill_tree_list:
            answer += 1
            
    return answer