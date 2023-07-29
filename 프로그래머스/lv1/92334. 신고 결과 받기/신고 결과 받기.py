def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report_dic = {name:set() for name in id_list}
    
    # 신고당한사람:{신고한 사람들}
    for r in report:
        user, reported = r.split()
        report_dic[reported].add(user)
            
    # 정지된 ID확인
    for user_name in id_list:
        user_list = report_dic.get(user_name)
        if len(user_list) >= k:    # 정지된 메일이면
            for user in user_list: # 신고한 사람에게 메일을 보낸다
                answer[id_list.index(user)] += 1
            
    return answer 