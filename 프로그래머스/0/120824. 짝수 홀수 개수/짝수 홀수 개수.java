class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2]; // [짝수의 개수, 홀수의 개수]

        for (int num : num_list) {
            answer[num % 2]++;
        }

        
        return answer;
    }
}