class Solution {
    public int solution(int M, int N) {
        int answer = (M-1) + M*(N-1);
        // 잘라야 하는 조각의 개수 -> M*N개
        // 가로로 만들어야하는 조각 -> M개 -> M-1번 가위질
        // 세로로 만들어야하는 조각 -> N개 -> N-1번 가위질을 M(가로개수만큼 반복) * M
        return answer;
    }
}