class Solution {
    public int[] solution(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n += arr[i];
        }
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}