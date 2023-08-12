def solution(nums):
    n = len(nums) // 2      # 가져갈 수 있는 폰켓몬 개수
    p_type = len(set(nums)) # 폰켓몬 종류
    
    if p_type > n:
        return n
    else:
        return p_type