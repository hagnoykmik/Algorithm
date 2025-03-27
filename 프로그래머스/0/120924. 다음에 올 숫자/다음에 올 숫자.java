class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int l = common.length - 1; // common의 마지막번째
        if (common[1] - common[0] == common[2] - common[1]) { // 등차라면
            answer = (common[1] - common[0]) + common[l];
        } else { // 등비라면
            answer = (common[1] / common[0]) * common[l];
        }
        return answer;
    }
}