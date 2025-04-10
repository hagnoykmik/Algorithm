class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2]; // [짝수의 개수, 홀수의 개수]
        int even_cnt = 0;
        int odd_cnt = 0;
        for (int num : num_list) {
            if (num % 2 == 0) {
                even_cnt += 1;
            } else {
                odd_cnt += 1;
            }
        }
        answer[0] = even_cnt;
        answer[1] = odd_cnt;
        
        return answer;
    }
}