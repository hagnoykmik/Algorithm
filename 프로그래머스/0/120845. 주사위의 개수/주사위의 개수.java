class Solution {
    public int solution(int[] box, int n) {
        int answer = (box[0]/n) * (box[1]/n) * (box[2]/n); // 실제로 넣을 수 있는 개수
        return answer;
    }
}