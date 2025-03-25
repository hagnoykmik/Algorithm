class Solution {
    public int solution(String[] babbling) {
        String[] str = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < str.length; j++) {
                // 조카가 할 수 있는 옹알이면 " "공백으로 변환
                babbling[i] = babbling[i].replace(str[j], " ");
            }
            
            // 공백제거했을 때 다 없어지면 발음 가능
            if (babbling[i].trim().length() == 0) {
                answer += 1;
            }
        }
        
        return answer;
    }
}