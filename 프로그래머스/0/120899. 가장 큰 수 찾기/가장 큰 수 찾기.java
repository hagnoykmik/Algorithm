class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int max_num = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max_num) {
                max_num = array[i]; // 최대값 갱신
                answer[0] = array[i];
                answer[1] = i;
            }
        }
        return answer;
    }
}